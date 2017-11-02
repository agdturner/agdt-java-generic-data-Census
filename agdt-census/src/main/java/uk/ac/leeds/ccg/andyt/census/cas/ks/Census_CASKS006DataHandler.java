/**
 * A component of a library for
 * <a href="http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS">MoSeS</a>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA.
 */
package uk.ac.leeds.ccg.andyt.census.cas.ks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * A <code>class</code> for handling an individual
 * <code>Census_CASKS006DataRecord</code> and collections of
 * <code>CASKS006DataRecords</code>.
 */
public class Census_CASKS006DataHandler extends Census_AbstractDataHandler {

    /**
     * Creates a new instance of <code>CASKS006DataHandler</code> for handling
     * CASKS006DataRecords stored in a formatted <code>File</code> The default
     * <code>File</code> is hard coded. To specify the <code>File</code> use
     * <code>CASKS006DataHandler(File)</code>. To set a different default
     * <code>File</code> edit the source code and recompile.
     * @throws java.io.IOException
     */
    public Census_CASKS006DataHandler() throws IOException {
        // this( new File(
        // "C:/Work/Projects/MoSeS/Workspace/CASKS006DataRecords.dat" ) );
        // Want also to setDirectory();
        // initMemoryReserve();
        // Default this.directory, this.file, this.randomAccessFile
        File directory = new File("C:/Work/Projects/MoSeS/Workspace/");
        this.init(directory);
        this._File = new File(directory, "CASKS006DataRecords.dat");
        if (!this._File.exists()) {
            this._File.createNewFile();
        }
        this._RecordLength = new Census_CASKS006DataRecord().getSizeInBytes();
        // System.out.println("this.recordLength " + this.recordLength);
        this._RandomAccessFile = new RandomAccessFile(this._File, "r");
    }

    /**
     * Creates a new instance of CASKS006DataHandler with Records loaded from
     * formattedFile.
     *
     * @param formattedFile
     *            Formatted file of CASKS006DataRecords
     * @throws java.io.IOException
     */
    public Census_CASKS006DataHandler(File formattedFile) throws IOException {
        // initMemoryReserve();
        this.init(formattedFile.getParentFile());
        this._RecordLength = new Census_CASKS006DataRecord().getSizeInBytes();
        load(formattedFile);
        System.out.println("CASKS006DataRecords loaded successfully");
    }

    /**
     * Loads <code>CAS001DataRecords</code> and prints out n randomly
     * @param directory to load source data from
     * @param n the number of loaded data records to print out.
     * @throws java.io.IOException
     */
    public void formatSourceData(
            File directory,
            int n)
            throws IOException {
        _RandomAccessFile = new RandomAccessFile(this._File, "rw");
        // Load from source
        File infile;
        long long0 = 0L;
        long RecordID = 0L;
        // // Load England
        // infile = new File(
        // "C:/work/data/census/2001/CAS/KeyStatistics/KS006EnglandOA.csv"
        // );
        // RecordID = format( infile, RecordID );
        // System.out.println( infile.toString() +
        // " formatted successfully " + RecordID + " records"); // 165665
        // long0 = RecordID;
        // Load Wales
        infile = new File(
                directory,
                "KS006WalesOA.csv");
        RecordID = format(infile, RecordID);
        System.out.println(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 9769
        long0 = RecordID;
        // // Load Scotland
        // infile = new File(
        // "C:/work/data/census/2001/CAS/KeyStatistics/KS006ScotlandOA.csv"
        // );
        // RecordID = format( infile, RecordID );
        // System.out.println( infile.toString() +
        // " formatted successfully " + ( RecordID - long0 ) + " records");
        // // 42604
        // long0 = RecordID;
        // // Load Northern Ireland
        // infile = new File(
        // "C:/work/data/census/2001/CAS/KeyStatistics/KS006NorthernIrelandOA.csv"
        // );
        // RecordID = format( infile, RecordID );
        // System.out.println( infile.toString() +
        // " formatted successfully " + ( RecordID - long0 ) + " records");
        // // 5022
        // tRandomAccessFile.close();
        load(this._File);
        print(20, new Random());
    }

    /**
     * Uses a <code>BufferedReader<code> and a <code>StreamTokenizer</code> to
     * read lines from the sourceFile <code>File</code>. The lines are converted
     * to <code>CASKS006DataRecords</code> and written to
     * <code>this.tRandomAccessFile</code>.
     *
     * @param sourceFile
     *            The source CASKS006DataRecords file to be formatted and
     *            written to <code>this.tRandomAccessFile</code>.
     * @param RecordID
     *            The <code>RecordID</code> to assign to the first
     *            <code>Census_CASKS006DataRecord</code>.
     * @return The <code>RecordID</code> assigned to the last
     *         <code>CASKS006DataRecords</code>.
     * @throws java.io.IOException
     */
    protected long format(File sourceFile, long RecordID) throws IOException {
        System.out.println("format( File( " + sourceFile.toString() + " ), RecordID( " + RecordID + " ))");
        BufferedReader aBufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile)));
        StreamTokenizer aStreamTokenizer = new StreamTokenizer(aBufferedReader);
        Generic_StaticIO.setStreamTokenizerSyntax1(aStreamTokenizer);
        String string0 = new String();
        String string1;
        String string2;
        long long0;
        long longZero = 0L;
        Census_CASKS006DataRecord aCASKS006DataRecord = new Census_CASKS006DataRecord();
        boolean print = false;
        int int10000 = 10000;
        // Skip the first line
        int tokenType = aStreamTokenizer.nextToken();
        while (tokenType != StreamTokenizer.TT_EOL) {
            tokenType = aStreamTokenizer.nextToken();
        }
        tokenType = aStreamTokenizer.nextToken();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_EOL:
                    long0 = RecordID % int10000;
                    print = (long0 == longZero);
                    if (print) {
                        string2 = aCASKS006DataRecord.toString();
                        System.out.println(string2);
                        string2 = string0;
                    }
                    // Write out
                    aCASKS006DataRecord.write(_RandomAccessFile);
                    RecordID++;
                    break;
                case StreamTokenizer.TT_WORD:
                    string1 = aStreamTokenizer.sval;
                    aCASKS006DataRecord = new Census_CASKS006DataRecord(RecordID, string1);
                    break;
            }
            string1 = string0;
            tokenType = aStreamTokenizer.nextToken();
        }
        System.out.println("Number of Records loaded = " + RecordID);
        return RecordID;
    }

    /**
     * @return a <code>Census_CASKS006DataRecord</code> with
     *         <code>Census_AbstractDataRecord.RecordID = RecordID</code>
     * @param RecordID
     *            The RecordID of the Census_CASKS006DataRecord to be returned.
     */
    public Census_AbstractDataRecord getDataRecord(
            long RecordID) {
        return getCASKS006DataRecord(RecordID);
    }

    /**
     * @return a <code>Census_CASKS006DataRecord</code> with
     *         <code>Census_CASKS006DataRecord.RecordID = RecordID</code>
     * @param RecordID
     *            The RecordID of the Census_CASKS006DataRecord to be returned.
     */
    public Census_CASKS006DataRecord getCASKS006DataRecord(
            long RecordID) {
        Census_CASKS006DataRecord result = null;
        try {
            this._RandomAccessFile.seek(_RecordLength * RecordID);
            result = new Census_CASKS006DataRecord(this._RandomAccessFile);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return result;
    }

    /**
     * Aggregates <code>CASKS006DataRecords</code> from OA To Ward for the OA
     * records in the range [startRecordID,endRecordID] and writes the results
     * to aRandomAccessFile
     *
     * @param aRandomAccessFile
     *            <code>RandomAccessFile</code> to which results are written
     * @param startRecordID
     *            The first OA RecordID in the sequence to be aggregated.
     * @param endRecordID
     *            The last OA RecordID in the sequence to be aggregated.
     * @throws java.io.IOException
     */
    public void aggregateOAToWard(RandomAccessFile aRandomAccessFile,
            long startRecordID, long endRecordID) throws IOException {
        TreeMap result = new TreeMap();
        Census_CASKS006DataRecord aCASKS006DataRecord;
        Census_CASKS006DataRecord bCASKS006DataRecord;
        String zoneCode;
        Object zoneCodeWard;
        // long newRecordID = startRecordIDForLeeds - 1L;
        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID < endRecordID; RecordID++) {
            aCASKS006DataRecord = (Census_CASKS006DataRecord) getDataRecord(RecordID);
            zoneCode = new String(aCASKS006DataRecord.getZone_Code());
            zoneCodeWard = zoneCode.substring(0, 6);
            if (result.containsKey(zoneCodeWard)) {
                bCASKS006DataRecord = (Census_CASKS006DataRecord) result.get(zoneCodeWard);
                result.remove(zoneCodeWard);
                result.put(zoneCodeWard, aCASKS006DataRecord.aggregate(bCASKS006DataRecord));
            } else {
                result.put(zoneCodeWard, aCASKS006DataRecord);
            }
        }
        write(aRandomAccessFile, result);
    }

    /**
     * Aggregates <code>CASKS006DataRecords</code> from OA To MSOA for the OA
     * records in the range [startRecordID,endRecordID] and writes the results
     * to aRandomAccessFile
     *
     * @param aRandomAccessFile
     *            <code>RandomAccessFile</code> to which results are written
     * @param startRecordID
     *            The first OA RecordID in the sequence to be aggregated.
     * @param endRecordID
     *            The last OA RecordID in the sequence to be aggregated.
     * @throws java.io.IOException
     */
    public void aggregateOAToMSOA(RandomAccessFile aRandomAccessFile,
            long startRecordID, long endRecordID) throws IOException {
        TreeMap result = new TreeMap();
        HashMap lookUpMSOAfromOAHashMap = get_LookUpMSOAfromOAHashMap();
        Census_CASKS006DataRecord aCASKS006DataRecord;
        Census_CASKS006DataRecord bCASKS006DataRecord;
        String zoneCode;
        Object zoneCodeMSOA;
        // long newRecordID = startRecordIDForLeeds - 1L;
        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID < endRecordID; RecordID++) {
            aCASKS006DataRecord = (Census_CASKS006DataRecord) getDataRecord(RecordID);
            zoneCode = new String(aCASKS006DataRecord.getZone_Code());
            zoneCodeMSOA = lookUpMSOAfromOAHashMap.get(zoneCode);
            if (result.containsKey(zoneCodeMSOA)) {
                bCASKS006DataRecord = (Census_CASKS006DataRecord) result.get(zoneCodeMSOA);
                result.remove(zoneCodeMSOA);
                result.put(zoneCodeMSOA, aCASKS006DataRecord.aggregate(bCASKS006DataRecord));
            } else {
                result.put(zoneCodeMSOA, aCASKS006DataRecord);
            }
        }
        write(aRandomAccessFile, result);
    }
}