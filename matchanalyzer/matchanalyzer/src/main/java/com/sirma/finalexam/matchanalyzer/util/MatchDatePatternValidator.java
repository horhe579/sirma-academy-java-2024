package com.sirma.finalexam.matchanalyzer.util;

import com.sirma.finalexam.matchanalyzer.csvparsers.CsvMatchProcessor;
import com.sirma.finalexam.matchanalyzer.interfaces.PatternValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MatchDatePatternValidator implements PatternValidator<LocalDate> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatchDatePatternValidator.class);
    private static final List<DateTimeFormatter> DATE_FORMATS = new ArrayList<>();
    static {
        // Numerical formats with different separators (/, -, .)
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("M/d/yyyy"));     // 6/16/2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MM/dd/yyyy"));   // 06/16/2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("M-d-yyyy"));     // 6-16-2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MM-dd-yyyy"));   // 06-16-2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("M.d.yyyy"));     // 6.16.2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MM.dd.yyyy"));   // 06.16.2024

        // Textual month formats with different separators (/, -, .)
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MMMM/d/yyyy"));  // June/16/2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MMM/d/yyyy"));   // Jun/16/2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MMMM-d-yyyy"));  // June-16-2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MMM-d-yyyy"));   // Jun-16-2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MMMM.d.yyyy"));  // June.16.2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MMM.d.yyyy"));   // Jun.16.2024

        // Leading zeroes variation
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("M/dd/yyyy"));    // 6/16/2024
        DATE_FORMATS.add(DateTimeFormatter.ofPattern("MM/d/yyyy"));    // 06/16/2024
    }


    //Make a map with all date formats and check if it matches any of them
    //returns null if invalid, otherwise returns Date
    @Override
    public LocalDate validate(String data) {
            for(DateTimeFormatter format : DATE_FORMATS)
            {
                try
                {
                    LocalDate date = LocalDate.parse(data, format);
                    return date;
                }
                catch (Exception e)
                {
                    LOGGER.warn("No match in format {} for date {}", format.toString(), data);
                }
            }
            return null;
    }
}
