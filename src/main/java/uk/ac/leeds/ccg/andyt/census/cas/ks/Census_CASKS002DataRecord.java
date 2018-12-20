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

import java.io.IOException;
import java.io.RandomAccessFile;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.census.core.StaticConverter;

/**
 * A <code>class</code> for representing a CASKS002 Data Record and providing
 * safe access to the data.
 * <ul>
 * <li>Developed for <a href="http://www.ncess.ac.uk/moses">MoSeS</a>.</li>
 * <li>Copyright (C) 2006 <a
 * href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy Turner</a>, <a
 * href="http://www.leeds.ac.uk//">University of Leeds</a>.</li>
 * </ul>
 * 
 * @author <a href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy
 *         Turner</a>
 * @version 1.0.0, 2006-08-10
 * @see CAS003DataHandler
 */
public class Census_CASKS002DataRecord extends Census_AbstractDataRecord {

    /*
     * Table KS002 Age structure: All people Footnotes and Comments for Table
     * KS002 1. 'Age' is age last birthday.
     */
    /**
     * KS0020001 = agesAll
     */
    protected int agesAll;
    /**
     * KS0020002 = ages0to4
     */
    protected int ages0to4;
    /**
     * KS0020003 = ages5to7
     */
    protected int ages5to7;
    /**
     * KS0020004 = ages8to9
     */
    protected int ages8to9;
    /**
     * KS0020005 = ages10to14
     */
    protected int ages10to14;
    /**
     * KS0020006 = age15
     */
    protected int age15;
    /**
     * KS0020007 = ages16to17
     */
    protected int ages16to17;
    /**
     * KS0020008 = ages18to19
     */
    protected int ages18to19;
    /**
     * KS0020009 = ages20to24
     */
    protected int ages20to24;
    /**
     * KS0020010 = ages25to29
     */
    protected int ages25to29;
    /**
     * KS0020011 = ages30to44
     */
    protected int ages30to44;
    /**
     * KS0020012 = ages45to59
     */
    protected int ages45to59;
    /**
     * KS0020013 = ages60to64
     */
    protected int ages60to64;
    /**
     * KS0020014 = ages65to74
     */
    protected int ages65to74;
    /**
     * KS0020015 = ages75to84
     */
    protected int ages75to84;
    /**
     * KS0020016 = ages85to89
     */
    protected int ages85to89;
    /**
     * KS0020017 = ages90AndOver
     */
    protected int ages90AndOver;

    /** Creates a new CASKS002DataRecord */
    public Census_CASKS002DataRecord() {
        init();
    }

    /**
     * Creates a new CASKS002DataRecord cloned from aCASKS002DataRecord
     *
     * @param aCASKS002DataRecord
     *            The CASKS002DataRecord from which this is cloned.
     */
    public Census_CASKS002DataRecord(Census_CASKS002DataRecord aCASKS002DataRecord) {
        init(aCASKS002DataRecord);
    }

    /**
     * Creates a new CASKS002DataRecord
     *
     * @param initZero
     *            To ensure initZero() is used instead of init()
     */
    public Census_CASKS002DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CASKS002DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public Census_CASKS002DataRecord(long RecordID, String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[18];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this.RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table KS002
        this.agesAll = StaticConverter.to_int(fields[1]);
        this.ages0to4 = StaticConverter.to_int(fields[2]);
        this.ages5to7 = StaticConverter.to_int(fields[3]);
        this.ages8to9 = StaticConverter.to_int(fields[4]);
        this.ages10to14 = StaticConverter.to_int(fields[5]);
        this.age15 = StaticConverter.to_int(fields[6]);
        this.ages16to17 = StaticConverter.to_int(fields[7]);
        this.ages18to19 = StaticConverter.to_int(fields[8]);
        this.ages20to24 = StaticConverter.to_int(fields[9]);
        this.ages25to29 = StaticConverter.to_int(fields[10]);
        this.ages30to44 = StaticConverter.to_int(fields[11]);
        this.ages45to59 = StaticConverter.to_int(fields[12]);
        this.ages60to64 = StaticConverter.to_int(fields[13]);
        this.ages65to74 = StaticConverter.to_int(fields[14]);
        this.ages75to84 = StaticConverter.to_int(fields[15]);
        this.ages85to89 = StaticConverter.to_int(fields[16]);
        this.ages90AndOver = StaticConverter.to_int(fields[17]);
    }

    /**
     * Creates a new CASKS002DataRecord
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public Census_CASKS002DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        this.RecordID = aRandomAccessFile.readLong();
        this.Zone_Code = new char[10];
        for (int i = 0; i < this.Zone_Code.length; i++) {
            Zone_Code[i] = aRandomAccessFile.readChar();
        }
        this.agesAll = aRandomAccessFile.readInt();
        this.ages0to4 = aRandomAccessFile.readInt();
        this.ages5to7 = aRandomAccessFile.readInt();
        this.ages8to9 = aRandomAccessFile.readInt();
        this.ages10to14 = aRandomAccessFile.readInt();
        this.age15 = aRandomAccessFile.readInt();
        this.ages16to17 = aRandomAccessFile.readInt();
        this.ages18to19 = aRandomAccessFile.readInt();
        this.ages20to24 = aRandomAccessFile.readInt();
        this.ages25to29 = aRandomAccessFile.readInt();
        this.ages30to44 = aRandomAccessFile.readInt();
        this.ages45to59 = aRandomAccessFile.readInt();
        this.ages60to64 = aRandomAccessFile.readInt();
        this.ages65to74 = aRandomAccessFile.readInt();
        this.ages75to84 = aRandomAccessFile.readInt();
        this.ages85to89 = aRandomAccessFile.readInt();
        this.ages90AndOver = aRandomAccessFile.readInt();
    }

    /**
     * Initialises all fields.
     */
    protected void init() {
        super.init();
        this.agesAll = Integer.MIN_VALUE;
        this.ages0to4 = Integer.MIN_VALUE;
        this.ages5to7 = Integer.MIN_VALUE;
        this.ages8to9 = Integer.MIN_VALUE;
        this.ages10to14 = Integer.MIN_VALUE;
        this.age15 = Integer.MIN_VALUE;
        this.ages16to17 = Integer.MIN_VALUE;
        this.ages18to19 = Integer.MIN_VALUE;
        this.ages20to24 = Integer.MIN_VALUE;
        this.ages25to29 = Integer.MIN_VALUE;
        this.ages30to44 = Integer.MIN_VALUE;
        this.ages45to59 = Integer.MIN_VALUE;
        this.ages60to64 = Integer.MIN_VALUE;
        this.ages65to74 = Integer.MIN_VALUE;
        this.ages75to84 = Integer.MIN_VALUE;
        this.ages85to89 = Integer.MIN_VALUE;
        this.ages90AndOver = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields.
     */
    protected void initZero() {
        super.init();
        this.agesAll = 0;
        this.ages0to4 = 0;
        this.ages5to7 = 0;
        this.ages8to9 = 0;
        this.ages10to14 = 0;
        this.age15 = 0;
        this.ages16to17 = 0;
        this.ages18to19 = 0;
        this.ages20to24 = 0;
        this.ages25to29 = 0;
        this.ages30to44 = 0;
        this.ages45to59 = 0;
        this.ages60to64 = 0;
        this.ages65to74 = 0;
        this.ages75to84 = 0;
        this.ages85to89 = 0;
        this.ages90AndOver = 0;
    }

    /**
     * Initialises all fields from those in aCASKS002DataRecord.
     *
     * @param aCASKS002DataRecord
     *            The Census_CASKS002DataRecord thats fields are used to initialise
            this.
     */
    protected void init(Census_CASKS002DataRecord aCASKS002DataRecord) {
        super.init(aCASKS002DataRecord);
        this.agesAll = aCASKS002DataRecord.agesAll;
        this.ages0to4 = aCASKS002DataRecord.ages0to4;
        this.ages5to7 = aCASKS002DataRecord.ages5to7;
        this.ages8to9 = aCASKS002DataRecord.ages8to9;
        this.ages10to14 = aCASKS002DataRecord.ages10to14;
        this.age15 = aCASKS002DataRecord.age15;
        this.ages16to17 = aCASKS002DataRecord.ages16to17;
        this.ages18to19 = aCASKS002DataRecord.ages18to19;
        this.ages20to24 = aCASKS002DataRecord.ages20to24;
        this.ages25to29 = aCASKS002DataRecord.ages25to29;
        this.ages30to44 = aCASKS002DataRecord.ages30to44;
        this.ages45to59 = aCASKS002DataRecord.ages45to59;
        this.ages60to64 = aCASKS002DataRecord.ages60to64;
        this.ages65to74 = aCASKS002DataRecord.ages65to74;
        this.ages75to84 = aCASKS002DataRecord.ages75to84;
        this.ages85to89 = aCASKS002DataRecord.ages85to89;
        this.ages90AndOver = aCASKS002DataRecord.ages90AndOver;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", agesAll " + agesAll + ", ages0to4 " + ages0to4 + ", ages5to7 " + ages5to7 + ", ages8to9 " + ages8to9 + ", ages10to14 " + ages10to14 + ", age15 " + age15 + ", ages16to17 " + ages16to17 + ", ages18to19 " + ages18to19 + ", ages20to24 " + ages20to24 + ", ages25to29 " + ages25to29 + ", ages30to44 " + ages30to44 + ", ages45to59 " + ages45to59 + ", ages60to64 " + ages60to64 + ", ages65to74 " + ages65to74 + ", ages75to84 " + ages75to84 + ", ages85to89 " + ages85to89 + ", ages90AndOver " + ages90AndOver;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        String result = super.toCSVString();
        result += "," + this.agesAll;
        result += "," + this.ages0to4;
        result += "," + this.ages5to7;
        result += "," + this.ages8to9;
        result += "," + this.ages10to14;
        result += "," + this.age15;
        result += "," + this.ages16to17;
        result += "," + this.ages18to19;
        result += "," + this.ages20to24;
        result += "," + this.ages25to29;
        result += "," + this.ages30to44;
        result += "," + this.ages45to59;
        result += "," + this.ages60to64;
        result += "," + this.ages65to74;
        result += "," + this.ages75to84;
        result += "," + this.ages85to89;
        result += "," + this.ages90AndOver;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        String result = super.toCSVStringFields();
        result += ",agesAll";
        result += ",ages0to4";
        result += ",ages5to7";
        result += ",ages8to9";
        result += ",ages10to14";
        result += ",age15";
        result += ",ages16to17";
        result += ",ages18to19";
        result += ",ages20to24";
        result += ",ages25to29";
        result += ",ages30to44";
        result += ",ages45to59";
        result += ",ages60to64";
        result += ",ages65to74";
        result += ",ages75to84";
        result += ",ages85to89";
        result += ",ages90AndOver";
        return result;
    }

    /**
     * Returns a copy of this.agesAll
     * @return 
     */
    public int getAgesAll() {
        return this.agesAll;
    }

    /**
     * Returns a copy of this.ages0to4
     * @return 
     */
    public int getAges0to4() {
        return this.ages0to4;
    }

    /**
     * Returns a copy of this.ages5to7
     * @return 
     */
    public int getAges5to7() {
        return this.ages5to7;
    }

    /**
     * Returns a copy of this.ages8to9
     * @return 
     */
    public int getAges8to9() {
        return this.ages8to9;
    }

    /**
     * Returns a copy of this.ages10to14
     * @return 
     */
    public int getAges10to14() {
        return this.ages10to14;
    }

    /**
     * Returns a copy of this.age15
     * @return 
     */
    public int getAge15() {
        return this.age15;
    }

    /**
     * Returns a copy of this.ages16to17
     * @return 
     */
    public int getAges16to17() {
        return this.ages16to17;
    }

    /**
     * Returns a copy of this.ages18to19
     * @return 
     */
    public int getAges18to19() {
        return this.ages18to19;
    }

    /**
     * Returns a copy of this.ages20to24
     * @return 
     */
    public int getAges20to24() {
        return this.ages20to24;
    }

    /**
     * Returns a copy of this.ages25to29
     * @return 
     */
    public int getAges25to29() {
        return this.ages25to29;
    }

    /**
     * Returns a copy of this.ages30to44
     * @return 
     */
    public int getAges30to44() {
        return this.ages30to44;
    }

    /**
     * Returns a copy of this.ages45to59
     * @return 
     */
    public int getAges45to59() {
        return this.ages45to59;
    }

    /**
     * Returns a copy of this.ages60to64
     * @return 
     */
    public int getAges60to64() {
        return this.ages60to64;
    }

    /**
     * Returns a copy of this.ages65to74
     * @return 
     */
    public int getAges65to74() {
        return this.ages65to74;
    }

    /**
     * Returns a copy of this.ages75to84
     * @return 
     */
    public int getAges75to84() {
        return this.ages75to84;
    }

    /**
     * Returns a copy of this.ages85to89
     * @return 
     */
    public int getAges85to89() {
        return this.ages85to89;
    }

    /**
     * Returns a copy of this.ages90AndOver
     * @return 
     */
    public int getAges90AndOver() {
        return this.ages90AndOver;
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     */
    @Override
    public void write(RandomAccessFile aRandomAccessFile) {
        super.write(aRandomAccessFile);
        write(
                aRandomAccessFile,
                true);
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     * @param avoidCallToSuper
     *            If true super.write() is not called
     */
    public void write(
            RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
            try {
                aRandomAccessFile.writeInt(agesAll);
                aRandomAccessFile.writeInt(ages0to4);
                aRandomAccessFile.writeInt(ages5to7);
                aRandomAccessFile.writeInt(ages8to9);
                aRandomAccessFile.writeInt(ages10to14);
                aRandomAccessFile.writeInt(age15);
                aRandomAccessFile.writeInt(ages16to17);
                aRandomAccessFile.writeInt(ages18to19);
                aRandomAccessFile.writeInt(ages20to24);
                aRandomAccessFile.writeInt(ages25to29);
                aRandomAccessFile.writeInt(ages30to44);
                aRandomAccessFile.writeInt(ages45to59);
                aRandomAccessFile.writeInt(ages60to64);
                aRandomAccessFile.writeInt(ages65to74);
                aRandomAccessFile.writeInt(ages75to84);
                aRandomAccessFile.writeInt(ages85to89);
                aRandomAccessFile.writeInt(ages90AndOver);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>Census_CASKS002DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS002DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS002DataRecord
     *            The <code>Census_CASKS002DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public Census_CASKS002DataRecord aggregate(Census_CASKS002DataRecord aCASKS002DataRecord) {
        Census_CASKS002DataRecord newCASKS002DataRecord = new Census_CASKS002DataRecord(
                aCASKS002DataRecord);
        newCASKS002DataRecord.agesAll += getAgesAll();
        newCASKS002DataRecord.ages0to4 += getAges0to4();
        newCASKS002DataRecord.ages5to7 += getAges5to7();
        newCASKS002DataRecord.ages8to9 += getAges8to9();
        newCASKS002DataRecord.ages10to14 += getAges10to14();
        newCASKS002DataRecord.age15 += getAge15();
        newCASKS002DataRecord.ages16to17 += getAges16to17();
        newCASKS002DataRecord.ages18to19 += getAges18to19();
        newCASKS002DataRecord.ages20to24 += getAges20to24();
        newCASKS002DataRecord.ages25to29 += getAges25to29();
        newCASKS002DataRecord.ages30to44 += getAges30to44();
        newCASKS002DataRecord.ages45to59 += getAges45to59();
        newCASKS002DataRecord.ages60to64 += getAges60to64();
        newCASKS002DataRecord.ages65to74 += getAges65to74();
        newCASKS002DataRecord.ages75to84 += getAges75to84();
        newCASKS002DataRecord.ages85to89 += getAges85to89();
        newCASKS002DataRecord.ages90AndOver += getAges90AndOver();
        return newCASKS002DataRecord;
    }

    /**
     * @return An aggregated <code>Census_CASKS002DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS002DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS002DataRecord
     *            The <code>Census_CASKS002DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public Census_CASKS002DataRecord aggregate(Census_CASKS002DataRecord aCASKS002DataRecord,
            long newRecordID, char[] newZone_Code) {
        Census_CASKS002DataRecord newCASKS002DataRecord = new Census_CASKS002DataRecord(this);
        newCASKS002DataRecord.RecordID = newRecordID;
        // newCASKS002DataRecord.Zone_Code = aCASKS002DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS002DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS002DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS002DataRecord.agesAll += getAgesAll();
        newCASKS002DataRecord.ages0to4 += getAges0to4();
        newCASKS002DataRecord.ages5to7 += getAges5to7();
        newCASKS002DataRecord.ages8to9 += getAges8to9();
        newCASKS002DataRecord.ages10to14 += getAges10to14();
        newCASKS002DataRecord.age15 += getAge15();
        newCASKS002DataRecord.ages16to17 += getAges16to17();
        newCASKS002DataRecord.ages18to19 += getAges18to19();
        newCASKS002DataRecord.ages20to24 += getAges20to24();
        newCASKS002DataRecord.ages25to29 += getAges25to29();
        newCASKS002DataRecord.ages30to44 += getAges30to44();
        newCASKS002DataRecord.ages45to59 += getAges45to59();
        newCASKS002DataRecord.ages60to64 += getAges60to64();
        newCASKS002DataRecord.ages65to74 += getAges65to74();
        newCASKS002DataRecord.ages75to84 += getAges75to84();
        newCASKS002DataRecord.ages85to89 += getAges85to89();
        newCASKS002DataRecord.ages90AndOver += getAges90AndOver();
        return newCASKS002DataRecord;
    }

    /**
     * Returns the size of this CASKS002Record in bytes as a long. This does not
     * account for serialVersionUID. A boolean is assumed to be the same size as
     * an int in bytes.
     * @return 
     */
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (17L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}