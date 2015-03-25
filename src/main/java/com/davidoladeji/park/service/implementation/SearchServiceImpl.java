package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.Booking;
import com.davidoladeji.park.model.Search;
import com.davidoladeji.park.repository.SearchRepository;
import com.davidoladeji.park.service.interfaces.BookingService;
import com.davidoladeji.park.service.interfaces.SearchService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.Date;
import java.util.List;

/**
 * Created by Daveola on 3/12/2015.
 */

@Stateless(name = "SearchServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchRepository searchRepository;


    public void saveSearch(Search search) {
        searchRepository.save(search);
    }

    public List<Search> findAllSearches() {
        List<Search> searchList = searchRepository.findAll();
        return searchList;
    }

    public void deleteSearch(Search search) {
        searchRepository.delete(search);
    }

    public void deleteAllSearch() {
        searchRepository.deleteAll();
    }


}
