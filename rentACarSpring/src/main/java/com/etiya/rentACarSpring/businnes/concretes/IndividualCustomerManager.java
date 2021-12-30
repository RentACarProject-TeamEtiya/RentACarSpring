package com.etiya.rentACarSpring.businnes.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.rentACarSpring.businnes.abstracts.message.LanguageWordService;
import com.etiya.rentACarSpring.businnes.constants.Messages;
import com.etiya.rentACarSpring.core.utilities.adapter.findexScoreServiceAdapter.findexScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.businnes.abstracts.IndividualCustomerService;
import com.etiya.rentACarSpring.businnes.dtos.IndividualCustomerSearchListDto;

import com.etiya.rentACarSpring.businnes.request.IndividualCustomerRequest.CreateIndividualCustomerRequest;
import com.etiya.rentACarSpring.businnes.request.IndividualCustomerRequest.DeleteIndividualCustomerRequest;
import com.etiya.rentACarSpring.businnes.request.IndividualCustomerRequest.UpdateIndividualCustomerRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccesDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccesResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.IndividualCustomerDao;
import com.etiya.rentACarSpring.entities.IndividualCustomer;


@Service
public class IndividualCustomerManager implements IndividualCustomerService {

    private IndividualCustomerDao individualCustomerDao;
    private ModelMapperService modelMapperService;
    private findexScoreService findexScoreService;
    private Environment environment;
    private LanguageWordService languageWordService;


    @Autowired
    public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao,
                                     ModelMapperService modelMapperService,findexScoreService findexScoreService, Environment environment,
                                     LanguageWordService languageWordService) {
        super();
        this.individualCustomerDao = individualCustomerDao;
        this.modelMapperService = modelMapperService;
        this.findexScoreService=findexScoreService;
        this.environment = environment;
        this.languageWordService = languageWordService;
    }

    @Override
    public DataResult<List<IndividualCustomerSearchListDto>> getAll() {
        List<IndividualCustomer> result = this.individualCustomerDao.findAll();
        List<IndividualCustomerSearchListDto> response = result.stream()
                .map(individualCustomer -> modelMapperService.forDto().map(individualCustomer, IndividualCustomerSearchListDto.class))
                .collect(Collectors.toList());

        return new SuccesDataResult<List<IndividualCustomerSearchListDto>>(response, languageWordService.getByLanguageAndKeyId(Messages.IndividualCustomerListed,Integer.parseInt(environment.getProperty("language"))));
    }

    @Override
    public Result save(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = modelMapperService.forRequest().map(createIndividualCustomerRequest, IndividualCustomer.class);
        individualCustomer.setFindexScore(findexScoreService.getIndividualFindexScore(individualCustomer.getIdentityNumber()));
        this.individualCustomerDao.save(individualCustomer);
        return new SuccesResult(languageWordService.getByLanguageAndKeyId(Messages.IndividualCustomerAdded,Integer.parseInt(environment.getProperty("language"))));
    }

    @Override
    public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = modelMapperService.forRequest().map(updateIndividualCustomerRequest, IndividualCustomer.class);
        individualCustomer.setFindexScore(findexScoreService.getIndividualFindexScore(individualCustomer.getIdentityNumber()));
        this.individualCustomerDao.save(individualCustomer);
        return new SuccesResult(languageWordService.getByLanguageAndKeyId(Messages.IndividualCustomerUpdated,Integer.parseInt(environment.getProperty("language"))));
    }

    @Override
    public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
        this.individualCustomerDao.deleteById(deleteIndividualCustomerRequest.getIndividualCustomersId());
        return new SuccesResult(languageWordService.getByLanguageAndKeyId(Messages.IndividualCustomerDeleted,Integer.parseInt(environment.getProperty("language"))));
    }


}
