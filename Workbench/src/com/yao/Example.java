package com.yao;

import com.yao.value.ServiceCall;
import com.yao.value.Usage;

public class Example {
    
    public void configure(Reader target) {
        target.addStrategy(ConfigureServiceCall());
        target.addStrategy(configureUsage());
    }

    private ReaderStrategy ConfigureServiceCall() {
        ReaderStrategy result = new ReaderStrategy("SVCL", ServiceCall.class);
        result.addFieldExtractor(4, 18, "customerName");
        result.addFieldExtractor(19, 23, "customerID");
        result.addFieldExtractor(24, 27, "callTypeCode");
        result.addFieldExtractor(28, 35, "dateOfCallString");
        return result;
    }

    private ReaderStrategy configureUsage() {
        ReaderStrategy result = new ReaderStrategy("USGE", Usage.class);
        result.addFieldExtractor(4, 8, "customerID");
        result.addFieldExtractor(9, 22, "customerName");
        result.addFieldExtractor(30, 30, "cycle");
        result.addFieldExtractor(31, 36, "readDate");
        return result;
    }

}
