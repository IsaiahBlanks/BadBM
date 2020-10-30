package BadBM.persist;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "DiskRun")
@NamedQueries({
        @NamedQuery(name = "DiskRun.findAll",
                query = "SELECT d FROM DiskRun d")
})
public class DiskRun implements Serializable {

    static final DecimalFormat DF = new DecimalFormat("###.##");
    static final DateFormat DATE_FORMAT = new SimpleDateFormat("EEE, MMM d HH:mm:ss");
    private static final long serialVersionUID = 1L;
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    // configuration
    @Column
    String diskInfo = null;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    Date startTime;
    @Column
    int totalMarks = 0;
    @Column
    private
    IOMode ioMode;
    @Column
    private
    BlockSequence blockOrder;
    @Column
    private
    int numMarks = 0;
    @Column
    private
    int numBlocks = 0;
    @Column
    private
    int blockSize = 0;
    @Column
    private
    long txSize = 0;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private
    Date endTime = null;
    @Column
    private
    double runMin = 0;
    @Column
    private
    double runMax = 0;
    @Column
    private
    double runAvg = 0;
    public DiskRun() {
        this.startTime = new Date();
    }
    public DiskRun(IOMode type, BlockSequence order) {
        this.startTime = new Date();
        setIoMode(type);
        setBlockOrder(order);
    }

    public static List<DiskRun> findAll() {
        EntityManager em = EM.getEntityManager();
        return em.createNamedQuery("DiskRun.findAll", DiskRun.class).getResultList();
    }

    public static int deleteAll() {
        EntityManager em = EM.getEntityManager();
        em.getTransaction().begin();
        int deletedCount = em.createQuery("DELETE FROM DiskRun").executeUpdate();
        em.getTransaction().commit();
        return deletedCount;
    }

    @Override
    public String toString() {
        return "Run(" + getIoMode() + "," + getBlockOrder() + "): " + totalMarks + " run avg: " + getRunAvg();
    }

    // display friendly methods

    public String getStartTimeString() {
        return DATE_FORMAT.format(startTime);
    }

    public String getMin() {
        return getRunMin() == -1 ? "- -" : DF.format(getRunMin());
    }

    public void setMin(double min) {
        setRunMin(min);
    }

    /**
     * Here I modified getMax so it will not return the same as getRunMax()
     * @return
     */
    public String getMax() {
        return getRunMax() == -1 ? "- -" : DF.format(getRunMax() + 1);
    }

    public void setMax(double max) {
        setRunMax(max);
    }

    public String getAvg() {
        return getRunAvg() == -1 ? "- -" : DF.format(getRunAvg());
    }

    public void SetAvg(double avg) {
        setRunAvg(avg);
    }

    public String getDuration() {
        if (getEndTime() == null) {
            return "unknown";
        }
        long duration = getEndTime().getTime() - startTime.getTime();
        long diffSeconds = duration / 1000 % 60;
        return diffSeconds + "s";
    }

    // basic getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiskInfo() {
        return diskInfo;
    }

    public void setDiskInfo(String info) {
        diskInfo = info;
    }

    // Utility methods for collection

    public IOMode getIoMode() {
        return ioMode;
    }

    public void setIoMode(IOMode ioMode) {
        this.ioMode = ioMode;
    }

    public BlockSequence getBlockOrder() {
        return blockOrder;
    }

    public void setBlockOrder(BlockSequence blockOrder) {
        this.blockOrder = blockOrder;
    }

    public int getNumMarks() {
        return numMarks;
    }

    public void setNumMarks(int numMarks) {
        this.numMarks = numMarks;
    }

    public int getNumBlocks() {
        return numBlocks;
    }

    public void setNumBlocks(int numBlocks) {
        this.numBlocks = numBlocks;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public long getTxSize() {
        return txSize;
    }

    public void setTxSize(long txSize) {
        this.txSize = txSize;
    }

    public double getRunMax() {
        return runMax;
    }

    public void setRunMax(double runMax) {
        this.runMax = runMax;
    }

    public double getRunMin() {
        return runMin;
    }

    public void setRunMin(double runMin) {
        this.runMin = runMin;
    }

    public double getRunAvg() {
        return runAvg;
    }

    public void setRunAvg(double runAvg) {
        this.runAvg = runAvg;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public enum IOMode {READ, WRITE, READ_WRITE}

    public enum BlockSequence {SEQUENTIAL, RANDOM}
}
