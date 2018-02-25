package com.websensus.reviews;

import static com.websensus.reviews.ReviewModule.REVIEWS_JSON_FILE;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.Arrays;

public final class ReviewGenerator {

  public static void main(String[] args) throws ParseException {
    // Parse command line options.
    DefaultParser optionParser = new DefaultParser();
    Options options = new Options();
    options.addOption(REVIEWS_JSON_FILE);

    System.out.println("ARGS: " + Arrays.toString(args));

    CommandLine line;
    line = optionParser.parse(options, args);


    // Get parser instance.
    Injector injector = Guice.createInjector(new ReviewModule());
    ReviewParser parser = injector.getInstance(ReviewParser.class);

    System.out.println("OPTIONS: " + Arrays.toString(line.getOptions()));

    System.out.println("reviews_json_file: " + line.getOptionValue(REVIEWS_JSON_FILE.getOpt()));

    final String dir = System.getProperty("user.dir");
    System.out.println("current dir = " + dir);


  }
}

