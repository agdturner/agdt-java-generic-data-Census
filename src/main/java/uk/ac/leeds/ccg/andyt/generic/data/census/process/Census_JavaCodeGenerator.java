/*
 * Copyright 2019 Centre for Computational Geography, University of Leeds.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.leeds.ccg.andyt.generic.data.census.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StreamTokenizer;
import uk.ac.leeds.ccg.andyt.generic.data.census.core.Census_Environment;
import uk.ac.leeds.ccg.andyt.generic.data.census.core.Census_Object;
import uk.ac.leeds.ccg.andyt.data.core.Data_Environment;
import uk.ac.leeds.ccg.andyt.data.format.Data_ReadTXT;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_Environment;

/**
 *
 * @author geoagdt
 */
public class Census_JavaCodeGenerator extends Census_Object implements Runnable {

    public Census_JavaCodeGenerator(Census_Environment e) {
        super(e);
    }

    public static void main(String[] args) {
        try {
            File dir = null;
            Census_Environment env = new Census_Environment(
                    new Data_Environment(new Generic_Environment()), dir);
            Census_JavaCodeGenerator p = new Census_JavaCodeGenerator(env);
            p.run();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public void run() {
//        try {
//            File f = this.env.getFiles().getInput2001LUT();
//            Data_ReadTXT rt = new Data_ReadTXT(env.de);
//            BufferedReader br = io.getBufferedReader(f);
//            StreamTokenizer st = new StreamTokenizer(br);
//            rt.readLine(st);
//        } catch (IOException ex) {
//            ex.printStackTrace(System.err);
//        }
    }

}
