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
package uk.ac.leeds.ccg.andyt.agdtcensus.cas;

import java.io.IOException;
import java.io.RandomAccessFile;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.math.StaticConverter;

/**
 * A <code>class</code> for representing a SWS
 * Method of travel to work (2001 SWS Level 3 Table 1)
 * Data Record and providing safe
 * access to the data.
 * There are 36 cells in this table.
 * +-------------------+---------+-------------------------------------------+
 * |                   | All     | Aged 16-74 in employment                  |
 * |                   | persons +-------------------+-----------------------+
 * |                   |         | Full-time student | Not full-time student |
 * +-------------------+---------+-------------------+-----------------------+
 * | Total             | 1       | 2                 | 3                     |
 * | Work/study mainly |         |                   |                       |
 * | at/from home      | 4 	     | 5                 | 6                     |
 * | Underground etc.  | 7       | 8                 | 9                     |
 * | Train             | 10      | 11                | 12                    |
 * | Bus etc.          | 13      | 14                | 15                    |
 * | Taxi              | 16      | 17                | 18                    |
 * | Car - driver      | 19      | 20                | 21                    |
 * | Car - passenger   | 22      | 23                | 24                    |
 * | Motorcycle etc.   | 25      | 26                | 27                    |
 * | Bicycle           | 28      | 29                | 30                    |
 * | On foot           | 31      | 32                | 33                    |
 * | Other             | 34      | 35                | 36                    |
 * +-------------------+---------+-------------------+-----------------------+
 *
 */
public class SWSDataRecord extends AbstractCASDataRecord {

    /**
     * Destination Zone Code
     */
    protected char[] _Destination_Zone_Code;
    /**
     * Total
     */
    protected int _Total;

    public SWSDataRecord() {
        _Init();
    }

    public SWSDataRecord(SWSDataRecord a_SWSDataRecord) {
        init(a_SWSDataRecord);
    }

    public SWSDataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CAS001DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public SWSDataRecord(
            long RecordID,
            String line)
            throws IOException {
        String[] fields = line.split(",");
        // String[] fieldsDummy = line.split( "," );
        // String[] fields = new String[ 226 ];
        // for ( int i = 0; i < fields.length; i ++ ) {
        // fields[ i ] = "";
        // }
        // System.arraycopy( fieldsDummy, 0, fields, 0, fields.length );
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].toCharArray();
        this._Destination_Zone_Code = fields[1].toCharArray();
        this._Total = StaticConverter.to_int(fields[2]);
    }

    /**
     * Creates a new <code>CAS001DataRecord</code> from
     * <code>aRandomAccessFile</code>. The
     * <code>aRandomAccessFile.getFilePointer()</code> changes only as the
     * <code>CAS001DataRecord</code> is read.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> from which this is created.
     * @throws java.io.IOException
     */
    public SWSDataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this._Destination_Zone_Code = new char[10];
            for (int i = 0; i < this._Destination_Zone_Code.length; i++) {
                _Destination_Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this._Total = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            // ioe0.printStackTrace();
            throw ioe0;
        }
    }

    /**
     * Initialises all fields.
     */
    @Override
    protected void _Init() {
        super._Init();
        this._Destination_Zone_Code = new char[10];
        for (int i = 0; i < _Destination_Zone_Code.length; i++) {
            // _Destination_Zone_Code[ i ] = 'X';
            _Destination_Zone_Code[i] = ' ';
        }
        this._Total = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields to zero.
     */
    protected void initZero() {
        super._Init();
        this._Destination_Zone_Code = new char[10];
        for (int i = 0; i < _Destination_Zone_Code.length; i++) {
            // _Destination_Zone_Code[ i ] = 'X';
            _Destination_Zone_Code[i] = ' ';
        }
        this._Total = 0;
    }

    /**
     * Initialises from <code>aCAS001DataRecord</code>.
     *
     * @param a_SWSDataRecord
     */
    protected void init(SWSDataRecord a_SWSDataRecord) {
        super.init(a_SWSDataRecord);
        this._Destination_Zone_Code = a_SWSDataRecord._Destination_Zone_Code;
        this._Total = a_SWSDataRecord._Total;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    @Override
    public String toString() {
        String result = super.toString();
        result += ", _Destination_Zone_Code " + new String(_Destination_Zone_Code);
        result += ", _Total " + _Total;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        String result = super.toCSVString();
        result += "," + new String(_Destination_Zone_Code);
        result += "," + _Total;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        String result = super.toCSVStringFields();
        result += ",_Destination_Zone_Code";
        result += ",_Total";
        return result;
    }

    /**
     * Returns a copy of this._Destination_Zone_Code converted to a String
     * @return 
     */
    public String get_Destination_Zone_Code() {
        return new String(this._Destination_Zone_Code);
    }

    /**
     * Returns a copy of this._Total
     * @return 
     */
    public int get_Total() {
        return this._Total;
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
    public void write(
            RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
            try {
                aRandomAccessFile.writeChars(new String(this._Destination_Zone_Code));
                aRandomAccessFile.writeInt(this._Total);
                } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += ((long) (_Destination_Zone_Code.length * Character.SIZE)) / getNumberOfBitsInByte();
        result += ((long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}