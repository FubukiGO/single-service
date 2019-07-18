package com.ygg.baba.app.common.util.property;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuezl on 2017/9/12.
 */
public class PropertyFactory {

    private static Map<String, AbstractProperties> pops = new HashMap<String, AbstractProperties>();

    private static synchronized AbstractProperties createProperties(String filename) {
        if (pops.containsKey(filename))
            return pops.get(filename);

        AbstractProperties pop = new AbstractProperties() {
            @Override
            public String getFilePath() {
                return filename;
            }

            @Override
            public String getName() {
                return filename;
            }
        };
        pop.loadProps();

        pops.put(filename, pop);
        return pop;
    }

    public static AbstractProperties getInstance(String filename) {
        if (pops.containsKey(filename))
            return pops.get(filename);
        return createProperties(filename);
    }
}
