package db;

import java.io.Serializable;
import java.util.NoSuchElementException;
/**
 * DbFileIterator is the iterator interface that all DB Dbfile should
 * implement.
 */
public interface DbFileIterator extends Serializable {
    /**
     * Opens the iterator
     * @throws DbException when there are problems opening/accessing the database.
     */
    public void open()
            throws DbException, TransactionAbortedException;

    /** @return true if there are more rows available. */
    public boolean hasNext()
            throws DbException, TransactionAbortedException;

    /**
     * Gets the next row from the operator (typically implementing by reading
     * from a child operator or an access method).
     *
     * @return The next row in the iterator.
     * @throws NoSuchElementException if there are no more rows
     */
    public Row next()
            throws DbException, TransactionAbortedException, NoSuchElementException;

    /**
     * Resets the iterator to the start.
     * @throws DbException When rewind is unsupported.
     */
    public void rewind() throws DbException, TransactionAbortedException;

    /**
     * Closes the iterator.
     */
    public void close();
}
