package com.cemgunduz.utils;

import com.cemgunduz.utils.entity.RestResponse;
import org.jsoup.nodes.Document;

/**
 * Created by cgunduz on 3/13/14.
 */
public interface WebUtils {

    public Document getScrapableDocument(String url);

    public RestResponse getRestResponse(String url);
}
