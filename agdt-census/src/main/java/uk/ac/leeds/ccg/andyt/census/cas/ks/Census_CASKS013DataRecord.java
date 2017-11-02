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
import uk.ac.leeds.ccg.andyt.generic.math.StaticConverter;

/**
 * For representing CAS KS013 Records and providing safe access to the data.
 */
public class Census_CASKS013DataRecord extends Census_AbstractDataRecord {

    /**
     * Table KS013 Qualifications and students: All people aged 16-74 NB: This
     * table contains counts of Persons Footnotes and Comments for Table KS013
     * for England and Wales 1 1+ 'O' level passes, 1+ CSE/GCSE any grades, NVQ
     * level 1, Foundation GNVQ. 2 5+ 'O' level passes, 5+ CSEs (grade 1), 5+
     * GCSEs (grades A-C), School Certificate, 1+ 'A' levels/'AS' levels, NVQ
     * level 2, Intermediate GNVQ. 3 2+ 'A' levels, 4+ 'AS' levels, Higher
     * School Certificate, NVQ level 3, Advanced GNVQ. 4 First degree, Higher
     * degree, NVQ levels 4 and 5, HNC, HND, Qualified Teacher Status, Qualified
     * Medical Doctor, Qualified Dentist, Qualified Nurse, Midwife, Heath
     * Visitor. Footnotes and Comments for Table KS013 for Scotland 1 Highest
     * level of Qualification is defined as: Group 1: 'O' Grade, Standard Grade,
     * Intermediate 1, Intermediate 2, City and Guilds Craft, SVQ level 1 or 2,
     * or equivalent. Group 2: Higher Grade, CSYS, ONC, OND, City and Guilds
     * Advanced Craft, RSA Advanced Diploma, SVQ level 3 or equivalent. Group 3:
     * HND, HNC, RSA Higher Diploma, SVQ level 4 or 5, or equivalent. Group 4:
     * First degree, Higher Degree, Professional Qualification. CDU Note Users
     * should note that there is a slight difference between the Key Statistics
     * data available at Census Area Statistics Postcode Sector (CASPCS) level
     * available from Casweb, and that available in percentage form from GROS,
     * via SuperTABLE CD, or from the SCROL website. In all available versions
     * of the Scottish Standard Tables and Census Area Statistics, the GROS
     * Output Area to Higher Area Index, AND THE VERSION OF THE KEY STATISTICS
     * AVAILABLE FROM CASWEB, output area 60QP002440 is assigned to CASPCS QPC23
     * (postcode sector EH14 4). In the version of the Key Statistics available
     * from GROS via SuperTABLE CD, or from the SCROL website, output area
     * 60QP002440 is assigned to CASPCS QPC24 (postcode sector EH14 5). The CDU
     * are awaiting further information from GROS about the assignment of output
     * area 60QP002440. Footnotes and Comments for Table KS013 for Northern
     * Ireland 1 GCSE (grades D-G), CSE (grades 2-5), 1-4 CSEs (grade 1), 1-4
     * GCSEs (grades A-C), 1-4 'O' level passes, NVQ level 1, GNVQ Foundation or
     * equivalents. 2 5+ CSEs (grade 1), 5+ GCSEs (grades A-C), 5+ 'O' level
     * passes, Senior Certificate, 1 'A' level, 1-3 AS levels, Advanced Senior
     * Certificate, NVQ level 2, GNVQ Intermediate or equivalents. 3 2+ 'A'
     * levels, 4+ AS levels, NVQ level 3, GNVQ Advanced or equivalents. 4 First
     * degree, NVQ level 4, HNC, HND or equivalents. 5 Higher degree, NVQ level
     * 5 or equivalents. 6 All students and schoolchildren are counted at their
     * term-time address.
     */
    protected int _AllPeopleAged16to74;
    protected int _PeopleAged16to74WithNoQualifications;
    protected int _PeopleAged16to74WithHighestQualificationAttainedLevel1;
    protected int _PeopleAged16to74WithHighestQualificationAttainedLevel2;
    protected int _PeopleAged16to74WithHighestQualificationAttainedLevel3;
    protected int _PeopleAged16to74WithHighestQualificationAttainedLevel4and5;
    // protected int _PeopleAged16to74WithOtherQualificationsLevelUnknown;
    protected int _FullTimeStudentsAndSchoolchildrenAged16to17;
    protected int _FullTimeStudentsAndSchoolchildrenAged18to74;
    protected int _FullTimeStudentsAged18to74EconomicallyActiveInEmployment;
    protected int _FullTimeStudentsAged18to74EconomicallyActiveUnemployed;
    protected int _FullTimeStudentsAged18to74EconomicallyInactive;

    /** Creates a new CASKS013Record */
    public Census_CASKS013DataRecord() {
        _Init();
    }

    /**
     * Creates a new CASKS013Record cloned from aCASKS013Record
     *
     * @param aCASKS013Record
     *            The CASKS013Record from which this is cloned.
     */
    public Census_CASKS013DataRecord(Census_CASKS013DataRecord aCASKS013Record) {
        init(aCASKS013Record);
    }

    /**
     * Creates a new CASKS013DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @param country
     * @throws java.io.IOException
     */
    public Census_CASKS013DataRecord(long RecordID, String line, String country)
            throws IOException {
        if (country.equalsIgnoreCase("Scotland")) {
            String[] fieldsDummy = line.split(",");
            String[] fields = new String[12];
            for (int i = 0; i < fields.length; i++) {
                fields[i] = "";
            }
            System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
            this._RecordID = RecordID;
            this.Zone_Code = fields[0].substring(1, 11).toCharArray();
            // From Table KS013
            this._AllPeopleAged16to74 = StaticConverter.to_int(fields[1]);
            this._PeopleAged16to74WithNoQualifications = StaticConverter.to_int(fields[2]);
            this._PeopleAged16to74WithHighestQualificationAttainedLevel1 = StaticConverter.to_int(fields[3]);
            this._PeopleAged16to74WithHighestQualificationAttainedLevel2 = StaticConverter.to_int(fields[4]);
            this._PeopleAged16to74WithHighestQualificationAttainedLevel3 = StaticConverter.to_int(fields[5]);
            this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = StaticConverter.to_int(fields[6]);
            // this._PeopleAged16to74WithOtherQualificationsLevelUnknown =
            // StaticConverter.to_int( fields[ 7 ] );
            this._FullTimeStudentsAndSchoolchildrenAged16to17 = StaticConverter.to_int(fields[7]);
            this._FullTimeStudentsAndSchoolchildrenAged18to74 = StaticConverter.to_int(fields[8]);
            this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment = StaticConverter.to_int(fields[9]);
            this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed = StaticConverter.to_int(fields[10]);
            this._FullTimeStudentsAged18to74EconomicallyInactive = StaticConverter.to_int(fields[11]);
        } else {
            if (country.equalsIgnoreCase("Northern Ireland")) {
                String[] fieldsDummy = line.split(",");
                String[] fields = new String[13];
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = "";
                }
                System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
                System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
                this._RecordID = RecordID;
                this.Zone_Code = fields[0].substring(1, 11).toCharArray();
                // From Table KS013
                this._AllPeopleAged16to74 = StaticConverter.to_int(fields[1]);
                this._PeopleAged16to74WithNoQualifications = StaticConverter.to_int(fields[2]);
                this._PeopleAged16to74WithHighestQualificationAttainedLevel1 = StaticConverter.to_int(fields[3]);
                this._PeopleAged16to74WithHighestQualificationAttainedLevel2 = StaticConverter.to_int(fields[4]);
                this._PeopleAged16to74WithHighestQualificationAttainedLevel3 = StaticConverter.to_int(fields[5]);
                this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = StaticConverter.to_int(fields[6]) + StaticConverter.to_int(fields[7]);
                this._FullTimeStudentsAndSchoolchildrenAged16to17 = StaticConverter.to_int(fields[8]);
                this._FullTimeStudentsAndSchoolchildrenAged18to74 = StaticConverter.to_int(fields[9]);
                this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment = StaticConverter.to_int(fields[10]);
                this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed = StaticConverter.to_int(fields[11]);
                this._FullTimeStudentsAged18to74EconomicallyInactive = StaticConverter.to_int(fields[12]);
            } else {
                String[] fieldsDummy = line.split(",");
                String[] fields = new String[12];
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = "";
                }
                System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
                // if ( country.equalsIgnoreCase( "England" ) ||
                // country.equalsIgnoreCase( "Wales" ) ) {
                this._RecordID = RecordID;
                this.Zone_Code = fields[0].substring(1, 11).toCharArray();
                // From Table KS013
                this._AllPeopleAged16to74 = StaticConverter.to_int(fields[1]);
                this._PeopleAged16to74WithNoQualifications = StaticConverter.to_int(fields[2]);
                this._PeopleAged16to74WithHighestQualificationAttainedLevel1 = StaticConverter.to_int(fields[3]);
                this._PeopleAged16to74WithHighestQualificationAttainedLevel2 = StaticConverter.to_int(fields[4]);
                this._PeopleAged16to74WithHighestQualificationAttainedLevel3 = StaticConverter.to_int(fields[5]);
                this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = StaticConverter.to_int(fields[6]);
                // this._PeopleAged16to74WithOtherQualificationsLevelUnknown =
                // StaticConverter.to_int( fields[ 7 ] );
                this._FullTimeStudentsAndSchoolchildrenAged16to17 = StaticConverter.to_int(fields[7]);
                this._FullTimeStudentsAndSchoolchildrenAged18to74 = StaticConverter.to_int(fields[8]);
                this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment = StaticConverter.to_int(fields[9]);
                this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed = StaticConverter.to_int(fields[10]);
                this._FullTimeStudentsAged18to74EconomicallyInactive = StaticConverter.to_int(fields[11]);
            }
        }
    }

    /**
     * Creates a new CASKS013Record
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public Census_CASKS013DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this._AllPeopleAged16to74 = aRandomAccessFile.readInt();
            this._PeopleAged16to74WithNoQualifications = aRandomAccessFile.readInt();
            this._PeopleAged16to74WithHighestQualificationAttainedLevel1 = aRandomAccessFile.readInt();
            this._PeopleAged16to74WithHighestQualificationAttainedLevel2 = aRandomAccessFile.readInt();
            this._PeopleAged16to74WithHighestQualificationAttainedLevel3 = aRandomAccessFile.readInt();
            this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = aRandomAccessFile.readInt();
            // this._PeopleAged16to74WithOtherQualificationsLevelUnknown =
            // aRandomAccessFile.readInt();
            this._FullTimeStudentsAndSchoolchildrenAged16to17 = aRandomAccessFile.readInt();
            this._FullTimeStudentsAndSchoolchildrenAged18to74 = aRandomAccessFile.readInt();
            this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment = aRandomAccessFile.readInt();
            this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed = aRandomAccessFile.readInt();
            this._FullTimeStudentsAged18to74EconomicallyInactive = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            // ioe0.printStackTrace();
            throw ioe0;
        }
    }

    /**
     * Initialise.
     */
    protected void _Init() {
        super._Init();
        this._AllPeopleAged16to74 = Integer.MIN_VALUE;
        this._PeopleAged16to74WithNoQualifications = Integer.MIN_VALUE;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel1 = Integer.MIN_VALUE;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel2 = Integer.MIN_VALUE;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel3 = Integer.MIN_VALUE;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = Integer.MIN_VALUE;
        // this._PeopleAged16to74WithOtherQualificationsLevelUnknown =
        // Integer.MIN_VALUE;
        this._FullTimeStudentsAndSchoolchildrenAged16to17 = Integer.MIN_VALUE;
        this._FullTimeStudentsAndSchoolchildrenAged18to74 = Integer.MIN_VALUE;
        this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment = Integer.MIN_VALUE;
        this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed = Integer.MIN_VALUE;
        this._FullTimeStudentsAged18to74EconomicallyInactive = Integer.MIN_VALUE;
    }

    /**
     * Initialise to zero.
     */
    protected void initZero() {
        super._Init();
        this._AllPeopleAged16to74 = 0;
        this._PeopleAged16to74WithNoQualifications = 0;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel1 = 0;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel2 = 0;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel3 = 0;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = 0;
        // this._PeopleAged16to74WithOtherQualificationsLevelUnknown = 0;
        this._FullTimeStudentsAndSchoolchildrenAged16to17 = 0;
        this._FullTimeStudentsAndSchoolchildrenAged18to74 = 0;
        this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment = 0;
        this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed = 0;
        this._FullTimeStudentsAged18to74EconomicallyInactive = 0;
    }

    /**
     * Initialises all fields from those in cASKS013Record.
     *
     * @param _CASKS013Record
     *            The CASKS013Record thats fields are used to initialise this.
     */
    protected void init(Census_CASKS013DataRecord _CASKS013Record) {
        super.init(_CASKS013Record);
        this._AllPeopleAged16to74 = _CASKS013Record._AllPeopleAged16to74;
        this._PeopleAged16to74WithNoQualifications = _CASKS013Record._PeopleAged16to74WithNoQualifications;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel1 = _CASKS013Record._PeopleAged16to74WithHighestQualificationAttainedLevel1;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel2 = _CASKS013Record._PeopleAged16to74WithHighestQualificationAttainedLevel2;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel3 = _CASKS013Record._PeopleAged16to74WithHighestQualificationAttainedLevel3;
        this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = _CASKS013Record._PeopleAged16to74WithHighestQualificationAttainedLevel4and5;
        // this._PeopleAged16to74WithOtherQualificationsLevelUnknown =
        // _CASKS013Record._PeopleAged16to74WithOtherQualificationsLevelUnknown;
        this._FullTimeStudentsAndSchoolchildrenAged16to17 = _CASKS013Record._FullTimeStudentsAndSchoolchildrenAged16to17;
        this._FullTimeStudentsAndSchoolchildrenAged18to74 = _CASKS013Record._FullTimeStudentsAndSchoolchildrenAged18to74;
        this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment = _CASKS013Record._FullTimeStudentsAged18to74EconomicallyActiveInEmployment;
        this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed = _CASKS013Record._FullTimeStudentsAged18to74EconomicallyActiveUnemployed;
        this._FullTimeStudentsAged18to74EconomicallyInactive = _CASKS013Record._FullTimeStudentsAged18to74EconomicallyInactive;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ",_AllPeopleAged16to74 " + _AllPeopleAged16to74 + ",_PeopleAged16to74WithNoQualifications " + _PeopleAged16to74WithNoQualifications + ",_PeopleAged16to74WithHighestQualificationAttainedLevel1 " + _PeopleAged16to74WithHighestQualificationAttainedLevel1 + ",_PeopleAged16to74WithHighestQualificationAttainedLevel2 " + _PeopleAged16to74WithHighestQualificationAttainedLevel2 + ",_PeopleAged16to74WithHighestQualificationAttainedLevel3 " + _PeopleAged16to74WithHighestQualificationAttainedLevel3 + ",_PeopleAged16to74WithHighestQualificationAttainedLevel4and5 " + _PeopleAged16to74WithHighestQualificationAttainedLevel4and5 +
                // ",_PeopleAged16to74WithOtherQualificationsLevelUnknown " +
                // _PeopleAged16to74WithOtherQualificationsLevelUnknown +
                ",_FullTimeStudentsAndSchoolchildrenAged16to17 " + _FullTimeStudentsAndSchoolchildrenAged16to17 + ",_FullTimeStudentsAndSchoolchildrenAged18to74 " + _FullTimeStudentsAndSchoolchildrenAged18to74 + ",_FullTimeStudentsAged18to74EconomicallyActiveInEmployment " + _FullTimeStudentsAged18to74EconomicallyActiveInEmployment + ",_FullTimeStudentsAged18to74EconomicallyActiveUnemployed " + _FullTimeStudentsAged18to74EconomicallyActiveUnemployed + ",_FullTimeStudentsAged18to74EconomicallyInactive " + _FullTimeStudentsAged18to74EconomicallyInactive;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + _AllPeopleAged16to74 + "," + _PeopleAged16to74WithNoQualifications + "," + _PeopleAged16to74WithHighestQualificationAttainedLevel1 + "," + _PeopleAged16to74WithHighestQualificationAttainedLevel2 + "," + _PeopleAged16to74WithHighestQualificationAttainedLevel3 + "," + _PeopleAged16to74WithHighestQualificationAttainedLevel4and5 +
                // "," + _PeopleAged16to74WithOtherQualificationsLevelUnknown +
                "," + _FullTimeStudentsAndSchoolchildrenAged16to17 + "," + _FullTimeStudentsAndSchoolchildrenAged18to74 + "," + _FullTimeStudentsAged18to74EconomicallyActiveInEmployment + "," + _FullTimeStudentsAged18to74EconomicallyActiveUnemployed + "," + _FullTimeStudentsAged18to74EconomicallyInactive;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",_AllPeopleAged16to74 " + ",_PeopleAged16to74WithNoQualifications " + ",_PeopleAged16to74WithHighestQualificationAttainedLevel1 " + ",_PeopleAged16to74WithHighestQualificationAttainedLevel2 " + ",_PeopleAged16to74WithHighestQualificationAttainedLevel3 " + ",_PeopleAged16to74WithHighestQualificationAttainedLevel4and5 " +
                // ",_PeopleAged16to74WithOtherQualificationsLevelUnknown " +
                ",_FullTimeStudentsAndSchoolchildrenAged16to17 " + ",_FullTimeStudentsAndSchoolchildrenAged18to74 " + ",_FullTimeStudentsAged18to74EconomicallyActiveInEmployment " + ",_FullTimeStudentsAged18to74EconomicallyActiveUnemployed " + ",_FullTimeStudentsAged18to74EconomicallyInactive ";
    }

    /**
     * Returns a copy of this._AllPeopleAged16to74
     * @return 
     */
    public int get_AllPeopleAged16to74() {
        return this._AllPeopleAged16to74;
    }

    /**
     * Returns a copy of this._PeopleAged16to74WithNoQualifications
     * @return 
     */
    public int get_PeopleAged16to74WithNoQualifications() {
        return this._PeopleAged16to74WithNoQualifications;
    }

    /**
     * Returns a copy of
     * this._PeopleAged16to74WithHighestQualificationAttainedLevel1
     * @return 
     */
    public int get_PeopleAged16to74WithHighestQualificationAttainedLevel1() {
        return this._PeopleAged16to74WithHighestQualificationAttainedLevel1;
    }

    /**
     * Returns a copy of
     * this._PeopleAged16to74WithHighestQualificationAttainedLevel2
     * @return 
     */
    public int get_PeopleAged16to74WithHighestQualificationAttainedLevel2() {
        return this._PeopleAged16to74WithHighestQualificationAttainedLevel2;
    }

    /**
     * Returns a copy of
     * this._PeopleAged16to74WithHighestQualificationAttainedLevel3
     * @return 
     */
    public int get_PeopleAged16to74WithHighestQualificationAttainedLevel3() {
        return this._PeopleAged16to74WithHighestQualificationAttainedLevel3;
    }

    /**
     * Returns a copy of
     * this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5
     * @return 
     */
    public int get_PeopleAged16to74WithHighestQualificationAttainedLevel4and5() {
        return this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5;
    }

    // /**
    // * Returns a copy of
    // this._PeopleAged16to74WithOtherQualificationsLevelUnknown
    // */
    // public int get_PeopleAged16to74WithOtherQualificationsLevelUnknown() {
    // return this._PeopleAged16to74WithOtherQualificationsLevelUnknown;
    // }
    /**
     * Returns a copy of this._FullTimeStudentsAndSchoolchildrenAged16to17
     * @return 
     */
    public int get_FullTimeStudentsAndSchoolchildrenAged16to17() {
        return this._FullTimeStudentsAndSchoolchildrenAged16to17;
    }

    /**
     * Returns a copy of this._FullTimeStudentsAndSchoolchildrenAged18to74
     * @return 
     */
    public int get_FullTimeStudentsAndSchoolchildrenAged18to74() {
        return this._FullTimeStudentsAndSchoolchildrenAged18to74;
    }

    /**
     * Returns a copy of
     * this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment
     * @return 
     */
    public int get_FullTimeStudentsAged18to74EconomicallyActiveInEmployment() {
        return this._FullTimeStudentsAged18to74EconomicallyActiveInEmployment;
    }

    /**
     * Returns a copy of
     * this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed
     * @return 
     */
    public int get_FullTimeStudentsAged18to74EconomicallyActiveUnemployed() {
        return this._FullTimeStudentsAged18to74EconomicallyActiveUnemployed;
    }

    /**
     * Returns a copy of this._FullTimeStudentsAged18to74EconomicallyInactive
     * @return 
     */
    public int get_FullTimeStudentsAged18to74EconomicallyInactive() {
        return this._FullTimeStudentsAged18to74EconomicallyInactive;
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
        write(aRandomAccessFile, true);
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
    public void write(RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
            try {
                aRandomAccessFile.writeInt(_AllPeopleAged16to74);
                aRandomAccessFile.writeInt(_PeopleAged16to74WithNoQualifications);
                aRandomAccessFile.writeInt(_PeopleAged16to74WithHighestQualificationAttainedLevel1);
                aRandomAccessFile.writeInt(_PeopleAged16to74WithHighestQualificationAttainedLevel2);
                aRandomAccessFile.writeInt(_PeopleAged16to74WithHighestQualificationAttainedLevel3);
                aRandomAccessFile.writeInt(_PeopleAged16to74WithHighestQualificationAttainedLevel4and5);
                // aRandomAccessFile.writeInt(
                // _PeopleAged16to74WithOtherQualificationsLevelUnknown );
                aRandomAccessFile.writeInt(_FullTimeStudentsAndSchoolchildrenAged16to17);
                aRandomAccessFile.writeInt(_FullTimeStudentsAndSchoolchildrenAged18to74);
                aRandomAccessFile.writeInt(_FullTimeStudentsAged18to74EconomicallyActiveInEmployment);
                aRandomAccessFile.writeInt(_FullTimeStudentsAged18to74EconomicallyActiveUnemployed);
                aRandomAccessFile.writeInt(_FullTimeStudentsAged18to74EconomicallyInactive);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>Census_CASKS013DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS013DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS013DataRecord
     *            The <code>Census_CASKS013DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public Census_CASKS013DataRecord aggregate(Census_CASKS013DataRecord aCASKS013DataRecord) {
        Census_CASKS013DataRecord newCASKS013DataRecord = new Census_CASKS013DataRecord(
                aCASKS013DataRecord);
        newCASKS013DataRecord._AllPeopleAged16to74 += get_AllPeopleAged16to74();
        newCASKS013DataRecord._PeopleAged16to74WithNoQualifications += get_PeopleAged16to74WithNoQualifications();
        newCASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel1 += get_PeopleAged16to74WithHighestQualificationAttainedLevel1();
        newCASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel2 += get_PeopleAged16to74WithHighestQualificationAttainedLevel2();
        newCASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel3 += get_PeopleAged16to74WithHighestQualificationAttainedLevel3();
        newCASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 += get_PeopleAged16to74WithHighestQualificationAttainedLevel4and5();
        // newCASKS013DataRecord._PeopleAged16to74WithOtherQualificationsLevelUnknown
        // += get_PeopleAged16to74WithOtherQualificationsLevelUnknown();
        newCASKS013DataRecord._FullTimeStudentsAndSchoolchildrenAged16to17 += get_FullTimeStudentsAndSchoolchildrenAged16to17();
        newCASKS013DataRecord._FullTimeStudentsAndSchoolchildrenAged18to74 += get_FullTimeStudentsAndSchoolchildrenAged18to74();
        newCASKS013DataRecord._FullTimeStudentsAged18to74EconomicallyActiveInEmployment += get_FullTimeStudentsAged18to74EconomicallyActiveInEmployment();
        newCASKS013DataRecord._FullTimeStudentsAged18to74EconomicallyActiveUnemployed += get_FullTimeStudentsAged18to74EconomicallyActiveUnemployed();
        newCASKS013DataRecord._FullTimeStudentsAged18to74EconomicallyInactive += get_FullTimeStudentsAged18to74EconomicallyInactive();
        return newCASKS013DataRecord;
    }

    /**
     * @return An aggregated <code>Census_CASKS013DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS013DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS013DataRecord
     *            The <code>Census_CASKS013DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public Census_CASKS013DataRecord aggregate(
            Census_CASKS013DataRecord aCASKS013DataRecord,
            long newRecordID,
            char[] newZone_Code) {
        Census_CASKS013DataRecord newCASKS013DataRecord = new Census_CASKS013DataRecord(this);
        newCASKS013DataRecord._RecordID = newRecordID;
        // newCASKS013DataRecord.Zone_Code = aCASKS013DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS013DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS013DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS013DataRecord._AllPeopleAged16to74 += get_AllPeopleAged16to74();
        newCASKS013DataRecord._PeopleAged16to74WithNoQualifications += get_PeopleAged16to74WithNoQualifications();
        newCASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel1 += get_PeopleAged16to74WithHighestQualificationAttainedLevel1();
        newCASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel2 += get_PeopleAged16to74WithHighestQualificationAttainedLevel2();
        newCASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel3 += get_PeopleAged16to74WithHighestQualificationAttainedLevel3();
        newCASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 += get_PeopleAged16to74WithHighestQualificationAttainedLevel4and5();
        // newCASKS013DataRecord._PeopleAged16to74WithOtherQualificationsLevelUnknown
        // += get_PeopleAged16to74WithOtherQualificationsLevelUnknown();
        newCASKS013DataRecord._FullTimeStudentsAndSchoolchildrenAged16to17 += get_FullTimeStudentsAndSchoolchildrenAged16to17();
        newCASKS013DataRecord._FullTimeStudentsAged18to74EconomicallyActiveInEmployment += get_FullTimeStudentsAged18to74EconomicallyActiveInEmployment();
        newCASKS013DataRecord._FullTimeStudentsAged18to74EconomicallyActiveUnemployed += get_FullTimeStudentsAged18to74EconomicallyActiveUnemployed();
        newCASKS013DataRecord._FullTimeStudentsAged18to74EconomicallyInactive += get_FullTimeStudentsAged18to74EconomicallyInactive();
        return newCASKS013DataRecord;
    }

    /**
     * Returns the size of this Record in bytes as a long. This does not account
     * for serialVersionUID. A boolean is assumed to be the same size as an int
     * in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (11L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}