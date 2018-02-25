package com.websensus.options;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public final class OptionsModule extends AbstractModule {

  private final CommandLine line;

  public OptionsModule(String[] args, Options options) throws ParseException {
    DefaultParser optionParser = new DefaultParser();
    this.line = optionParser.parse(options, args);
  }

  @Override
  protected void configure() {}

  @Provides
  CommandLine provideCommandLine() {
    return line;
  }
}
