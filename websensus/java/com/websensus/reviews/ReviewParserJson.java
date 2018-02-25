package com.websensus.reviews;

import com.google.inject.Inject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

/**
 * JSON Review Object Format
 * {"reviewerID":"AEZ3CR6BKIROJ",
 * "asin":"0594451647",
 * "reviewerName":"Mark Dietter",
 * "helpful":[0,0],
 * "reviewText":"It's OK",
 * "overall":4.0,
 * "summary":"A nice easy to use accessory.",
 * "unixReviewTime":1405036800,
 * "reviewTime":"07 11, 2014"}
 */
public class ReviewParserJson implements ReviewParser {

    @Inject
    ReviewParserJson(JsonArray reviewsArray) {
        System.out.println("JsonArray Size: " + reviewsArray.size());
        for (JsonElement element : reviewsArray) {
          JsonObject reviewObj = element.getAsJsonObject();
          String reviewerId = reviewObj.get("reviewerID").getAsString();
          System.out.println(reviewerId);
        }
    }
}
