package com.websensus.reviews;

import static com.websensus.reviews.ReviewModule.REVIEWS_JSON_FILE;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.websensus.options.OptionsModule;
import java.io.IOException;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.Options;

public final class ReviewGenerator {

  public static void main(String[] args) throws ParseException, IOException {
    // Parse command line options.
    Options options = new Options();
    options.addOption(REVIEWS_JSON_FILE);
    // Get parser instance.
    Injector injector = Guice.createInjector(new OptionsModule(args, options), new ReviewModule());
    ReviewParser parser = injector.getInstance(ReviewParser.class);

  }
}

