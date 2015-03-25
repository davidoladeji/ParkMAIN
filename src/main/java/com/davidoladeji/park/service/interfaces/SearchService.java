package com.davidoladeji.park.service.interfaces;

import com.davidoladeji.park.model.Search;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Daveola on 3/12/2015.
 */

@Remote
public interface SearchService {

    public void saveSearch(Search search);

    public List<Search> findAllSearches();

    public void deleteSearch(Search search);

    public void deleteAllSearch();
}
