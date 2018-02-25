package com.websensus.reviews;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import java.io.File;
import java.io.IOException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

public class ReviewModule extends AbstractModule {

  public static final Option REVIEWS_JSON_FILE = new Option("r", "reviews_json_file",
      true, "File path to json reviews file.");

  @Override
  protected void configure() {
    binder().bind(ReviewParser.class).to(ReviewParserJson.class);
  }

  @Provides
  JsonArray provideReviewsJson(CommandLine line) throws IOException {
    Gson gson = new Gson();
    String jsonFile = line.getOptionValue(REVIEWS_JSON_FILE.getOpt());
    JsonArray reviews = Files
        .readLines(new File(jsonFile), Charsets.UTF_8, new LineProcessor<JsonArray>() {

          private final JsonArray reviewArray = new JsonArray();
          private final Gson gson = new Gson();
          private final Integer MAX = 10;

          private Integer COUNT = 0;

          @Override
          public boolean processLine(String line) throws IOException {
            reviewArray.add(gson.fromJson(line, JsonObject.class));
            return ++COUNT >= MAX ? false : true;
          }

          @Override
          public JsonArray getResult() {
            return reviewArray;
          }
        });
    return reviews;
  }
}
