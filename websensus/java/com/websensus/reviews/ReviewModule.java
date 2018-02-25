package com.websensus.reviews;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.commons.cli.Option;

public class ReviewModule extends AbstractModule {

  static final Option REVIEWS_JSON_FILE = new Option("r", "reviews_json_file", true,
      "File path to json reviews file.");

  @Override
  protected void configure() {
    binder().bind(ReviewParser.class).to(ReviewParserJson.class);
  }

  @Provides
  JsonObject provideReviewsJson() {
    Gson gson = new Gson();
    JsonObject reviewObj = gson.fromJson("", JsonObject.class);
    return reviewObj;
  }
}
