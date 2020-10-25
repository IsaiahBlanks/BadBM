package BadBM.ui;

import BadBM.App;
import BadBM.Util;
import BadBM.persist.DiskRun;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import static BadBM.App.dataDir;
import static java.awt.Font.PLAIN;

/**
 *
 */
@SuppressWarnings("rawtypes")
public final class MainFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    DecimalFormat df = new DecimalFormat("###.###");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem autoRemoveCheckBoxMenuItem;
    private javax.swing.JCheckBoxMenuItem autoResetCheckBoxMenuItem;
    private javax.swing.JComboBox blockSizeCombo;
    private javax.swing.JButton chooseButton;
    private javax.swing.JMenuItem clearLogsItem;
    private javax.swing.JMenuItem clearRunsItem;
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JMenuItem deleteDataMenuItem;
    private javax.swing.JScrollPane eventScrollPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel fileSizeLabel;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel locationPanel;
    private javax.swing.JTextField locationText;
    private javax.swing.JComboBox modeCombo;
    private javax.swing.JPanel mountPanel;
    private javax.swing.JTextArea msgTextArea;
    private javax.swing.JCheckBoxMenuItem multiFileCheckBoxMenuItem;
    private javax.swing.JComboBox numBlocksCombo;
    private javax.swing.JComboBox numFilesCombo;
    private javax.swing.JButton openLocButton;
    private javax.swing.JMenu optionMenu;
    private javax.swing.JComboBox<DiskRun.BlockSequence> orderComboBox;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JLabel rAvgLabel;
    private javax.swing.JLabel rMaxLabel;
    private javax.swing.JLabel rMinLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JMenuItem resetSequenceMenuItem;
    private RunPanel runPanel;
    private javax.swing.JCheckBoxMenuItem showMaxMinCheckBoxMenuItem;
    private javax.swing.JButton startButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JProgressBar totalTxProgBar;
    private javax.swing.JLabel wAvgLabel;
    private javax.swing.JLabel wMaxLabel;
    private javax.swing.JLabel wMinLabel;
    private javax.swing.JCheckBoxMenuItem writeSyncCheckBoxMenuItem;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        Gui.createChartPanel();
        mountPanel.setLayout(new BorderLayout());
        Gui.chartPanel.setSize(mountPanel.getSize());
        Gui.chartPanel.setSize(mountPanel.getWidth(), 200);
        mountPanel.add(Gui.chartPanel);
        totalTxProgBar.setStringPainted(true);
        totalTxProgBar.setValue(0);
        totalTxProgBar.setString("");
        setTitle(getTitle() + " " + App.getVersion());

        // auto scroll the text area.
        DefaultCaret caret = (DefaultCaret) msgTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        // init order combo box
        orderComboBox.addItem(DiskRun.BlockSequence.SEQUENTIAL);
        orderComboBox.addItem(DiskRun.BlockSequence.RANDOM);
    }

    public JPanel getMountPanel() {
        return mountPanel;
    }

    /**
     * This method is called when the gui needs to be updated after a new config
     * has been loaded.
     */
    public void refreshConfig() {
        if (App.locationDir != null) { // set the location dir if not null
            setLocation(App.locationDir.getAbsolutePath());
        }
        multiFileCheckBoxMenuItem.setSelected(App.multiFile);
        autoRemoveCheckBoxMenuItem.setSelected(App.autoRemoveData);
        autoResetCheckBoxMenuItem.setSelected(App.autoReset);
        showMaxMinCheckBoxMenuItem.setSelected(App.showMaxMin);
        writeSyncCheckBoxMenuItem.setSelected(App.writeSyncEnable);

        String modeStr = "unset";
        if (!App.readTest && App.writeTest) {
            modeStr = "write";
        } else if (App.readTest && !App.writeTest) {
            modeStr = "read";
        } else if (App.readTest && App.writeTest) {
            modeStr = "write&read";
        } else {
            msg("WARNING: invalid mode detected");
        }
        modeCombo.setSelectedItem(modeStr);

        //String blockOrderStr = App.randomEnable ? "random":"sequential";
        orderComboBox.setSelectedItem(App.blockSequence);

        numFilesCombo.setSelectedItem(String.valueOf(App.numOfMarks));
        numBlocksCombo.setSelectedItem(String.valueOf(App.numOfBlocks));
        blockSizeCombo.setSelectedItem(String.valueOf(App.blockSizeKb));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        mountPanel = new javax.swing.JPanel();
        controlsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numBlocksCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        blockSizeCombo = new javax.swing.JComboBox();
        startButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        numFilesCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        modeCombo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        fileSizeLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        orderComboBox = new javax.swing.JComboBox<DiskRun.BlockSequence>();
        jLabel14 = new javax.swing.JLabel();
        wMinLabel = new javax.swing.JLabel();
        wMaxLabel = new javax.swing.JLabel();
        wAvgLabel = new javax.swing.JLabel();
        rMinLabel = new javax.swing.JLabel();
        rMaxLabel = new javax.swing.JLabel();
        rAvgLabel = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        runPanel = new RunPanel();
        eventScrollPane = new javax.swing.JScrollPane();
        msgTextArea = new javax.swing.JTextArea();
        locationPanel = new javax.swing.JPanel();
        chooseButton = new javax.swing.JButton();
        locationText = new javax.swing.JTextField();
        openLocButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        progressPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        totalTxProgBar = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        optionMenu = new javax.swing.JMenu();
        clearRunsItem = new javax.swing.JMenuItem();
        clearLogsItem = new javax.swing.JMenuItem();
        deleteDataMenuItem = new javax.swing.JMenuItem();
        resetSequenceMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        multiFileCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        autoRemoveCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        autoResetCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        showMaxMinCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        writeSyncCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jDiskMark");

        mountPanel.setBackground(new java.awt.Color(0, 51, 153));
        mountPanel.setMaximumSize(new java.awt.Dimension(503, 200));

        javax.swing.GroupLayout mountPanelLayout = new javax.swing.GroupLayout(mountPanel);
        mountPanel.setLayout(mountPanelLayout);
        mountPanelLayout.setHorizontalGroup(
                mountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        mountPanelLayout.setVerticalGroup(
                mountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        controlsPanel.setPreferredSize(new java.awt.Dimension(250, 420));

        jLabel1.setText("Write Min");

        jLabel2.setText("Write Max");

        jLabel3.setText("Write Avg");

        numBlocksCombo.setEditable(true);
        numBlocksCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096", "8192"}));
        numBlocksCombo.setSelectedIndex(6);
        numBlocksCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numBlocksComboActionPerformed(evt);
            }
        });

        jLabel5.setText("No. Blocks");

        jLabel6.setText("Block (KB)");

        blockSizeCombo.setEditable(true);
        blockSizeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"2", "4", "8", "16", "32", "64", "128", "256", "512", "1024", "2048"}));
        blockSizeCombo.setSelectedIndex(8);
        blockSizeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockSizeComboActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("No. Marks");

        numFilesCombo.setEditable(true);
        numFilesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"25", "50", "75", "100", "150", "200", "250"}));
        numFilesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numFilesComboActionPerformed(evt);
            }
        });

        jLabel4.setText("IO Mode");

        modeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"write", "read", "write&read"}));
        modeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeComboActionPerformed(evt);
            }
        });

        jLabel9.setText("Mark Size (KB)");

        fileSizeLabel.setText("- -");

        jLabel10.setText("Read Min");

        jLabel11.setText("Read Max");

        jLabel12.setText("Read Avg");

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Tx Rates (MB/s)");

        orderComboBox.setMaximumSize(new java.awt.Dimension(106, 32767));
        orderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderComboBoxActionPerformed(evt);
            }
        });

        jLabel14.setText("Block Order");

        wMinLabel.setText("- -");

        wMaxLabel.setText("- -");

        wAvgLabel.setText("- -");

        rMinLabel.setText("- -");

        rMaxLabel.setText("- -");

        rAvgLabel.setText("- -");

        javax.swing.GroupLayout controlsPanelLayout = new javax.swing.GroupLayout(controlsPanel);
        controlsPanel.setLayout(controlsPanelLayout);
        controlsPanelLayout.setHorizontalGroup(
                controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlsPanelLayout.createSequentialGroup()
                                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(rMaxLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                        .addComponent(rMinLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(wAvgLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(wMaxLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(wMinLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(rAvgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(20, 20, 20))
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlsPanelLayout.createSequentialGroup()
                                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel14)
                                                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(fileSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(controlsPanelLayout.createSequentialGroup()
                                                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(blockSizeCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                                                        .addComponent(numBlocksCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                                                        .addComponent(numFilesCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                                                        .addComponent(orderComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(modeCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 94, Short.MAX_VALUE)
                                                                        .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                                                .addContainerGap())))))
        );
        controlsPanelLayout.setVerticalGroup(
                controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlsPanelLayout.createSequentialGroup()
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startButton)
                                        .addComponent(resetButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(modeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(orderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(numFilesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(numBlocksCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(blockSizeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(fileSizeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(wMinLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(wMaxLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(wAvgLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(rMinLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(rMaxLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(rAvgLabel))
                                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(mountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(controlsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(mountPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(controlsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 6, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Previous Runs", runPanel);

        msgTextArea.setEditable(false);
        msgTextArea.setColumns(20);
        msgTextArea.setFont(new java.awt.Font("Monospaced", PLAIN, 11)); // NOI18N
        msgTextArea.setRows(5);
        msgTextArea.setTabSize(4);
        eventScrollPane.setViewportView(msgTextArea);

        tabbedPane.addTab("Event Logs", eventScrollPane);

        chooseButton.setText("Browse");
        chooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseButtonActionPerformed(evt);
            }
        });

        locationText.setEditable(false);

        openLocButton.setText("Open");
        openLocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openLocButtonActionPerformed(evt);
            }
        });

        jLabel15.setText("/jDiskMarkData");

        javax.swing.GroupLayout locationPanelLayout = new javax.swing.GroupLayout(locationPanel);
        locationPanel.setLayout(locationPanelLayout);
        locationPanelLayout.setHorizontalGroup(
                locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(locationPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(locationText, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(openLocButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        locationPanelLayout.setVerticalGroup(
                locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(locationPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(locationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chooseButton)
                                        .addComponent(openLocButton)
                                        .addComponent(jLabel15))
                                .addContainerGap(140, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Data Location", locationPanel);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Total Tx (KB)");

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
                progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalTxProgBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        progressPanelLayout.setVerticalGroup(
                progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalTxProgBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuBar1.add(fileMenu);

        optionMenu.setText("Options");

        clearRunsItem.setText("Clear Previous Runs");
        clearRunsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearRunsItemActionPerformed(evt);
            }
        });
        optionMenu.add(clearRunsItem);

        clearLogsItem.setText("Clear Event Logs");
        clearLogsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearLogsItemActionPerformed(evt);
            }
        });
        optionMenu.add(clearLogsItem);

        deleteDataMenuItem.setText("Delete Data Dir");
        deleteDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDataMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(deleteDataMenuItem);

        resetSequenceMenuItem.setText("Reset Sequence");
        resetSequenceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSequenceMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(resetSequenceMenuItem);
        optionMenu.add(jSeparator1);

        multiFileCheckBoxMenuItem.setSelected(true);
        multiFileCheckBoxMenuItem.setText("Multi Data File");
        multiFileCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiFileCheckBoxMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(multiFileCheckBoxMenuItem);

        autoRemoveCheckBoxMenuItem.setSelected(true);
        autoRemoveCheckBoxMenuItem.setText("Auto Remove Data Dir");
        autoRemoveCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoRemoveCheckBoxMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(autoRemoveCheckBoxMenuItem);

        autoResetCheckBoxMenuItem.setSelected(true);
        autoResetCheckBoxMenuItem.setText("Auto Reset");
        autoResetCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoResetCheckBoxMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(autoResetCheckBoxMenuItem);

        showMaxMinCheckBoxMenuItem.setSelected(true);
        showMaxMinCheckBoxMenuItem.setText("Show Max Min");
        showMaxMinCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMaxMinCheckBoxMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(showMaxMinCheckBoxMenuItem);

        writeSyncCheckBoxMenuItem.setSelected(true);
        writeSyncCheckBoxMenuItem.setText("Write Sync");
        writeSyncCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeSyncCheckBoxMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(writeSyncCheckBoxMenuItem);

        jMenuBar1.add(optionMenu);

        helpMenu.setText("Help");

        jMenuItem2.setText("About...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem2);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(progressPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tabbedPane)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseButtonActionPerformed
        if (App.locationDir != null && App.locationDir.exists()) {
            Gui.selFrame.setInitDir(App.locationDir);
        }
        Gui.selFrame.setVisible(true);
    }//GEN-LAST:event_chooseButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if (App.state == App.State.DISK_TEST_STATE) {
            App.cancelBenchmark();
        } else if (App.state == App.State.IDLE_STATE) {
            applyTestParams();
            App.startBenchmark();
        }

    }//GEN-LAST:event_startButtonActionPerformed

    private void blockSizeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockSizeComboActionPerformed
        App.blockSizeKb = Integer.valueOf((String) blockSizeCombo.getSelectedItem());
        fileSizeLabel.setText(String.valueOf(App.targetMarkSizeKb()));
        totalTxProgBar.setString(String.valueOf(App.targetTxSizeKb()));
    }//GEN-LAST:event_blockSizeComboActionPerformed

    private void numBlocksComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numBlocksComboActionPerformed
        App.numOfBlocks = Integer.valueOf((String) numBlocksCombo.getSelectedItem());
        fileSizeLabel.setText(String.valueOf(App.targetMarkSizeKb()));
        totalTxProgBar.setString(String.valueOf(App.targetTxSizeKb()));
    }//GEN-LAST:event_numBlocksComboActionPerformed

    private void numFilesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFilesComboActionPerformed
        App.numOfMarks = Integer.valueOf((String) numFilesCombo.getSelectedItem());
        fileSizeLabel.setText(String.valueOf(App.targetMarkSizeKb()));
        totalTxProgBar.setString(String.valueOf(App.targetTxSizeKb()));
    }//GEN-LAST:event_numFilesComboActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        App.resetTestData();
        Gui.resetTestData();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void modeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeComboActionPerformed
        String modeStr = (String) modeCombo.getSelectedItem();
        App.readTest = modeStr.contains("read");
        App.writeTest = modeStr.contains("write");
    }//GEN-LAST:event_modeComboActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(Gui.mainFrame,
                "jDiskMark " + App.getVersion(), "About...", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void openLocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openLocButtonActionPerformed
        try {
            Desktop.getDesktop().open(App.locationDir);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openLocButtonActionPerformed

    private void clearLogsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearLogsItemActionPerformed
        clearMessages();
    }//GEN-LAST:event_clearLogsItemActionPerformed

    private void multiFileCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiFileCheckBoxMenuItemActionPerformed
        App.multiFile = multiFileCheckBoxMenuItem.getState();
        App.saveConfig();
    }//GEN-LAST:event_multiFileCheckBoxMenuItemActionPerformed

    private void autoRemoveCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoRemoveCheckBoxMenuItemActionPerformed
        App.autoRemoveData = autoRemoveCheckBoxMenuItem.getState();
        App.saveConfig();
    }//GEN-LAST:event_autoRemoveCheckBoxMenuItemActionPerformed

    private void deleteDataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDataMenuItemActionPerformed
        Util.deleteDirectory(dataDir);
    }//GEN-LAST:event_deleteDataMenuItemActionPerformed

    private void autoResetCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoResetCheckBoxMenuItemActionPerformed
        App.autoReset = autoResetCheckBoxMenuItem.getState();
        App.saveConfig();
    }//GEN-LAST:event_autoResetCheckBoxMenuItemActionPerformed

    private void resetSequenceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSequenceMenuItemActionPerformed
        App.resetSequence();
    }//GEN-LAST:event_resetSequenceMenuItemActionPerformed

    private void showMaxMinCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMaxMinCheckBoxMenuItemActionPerformed
        App.showMaxMin = showMaxMinCheckBoxMenuItem.getState();
    }//GEN-LAST:event_showMaxMinCheckBoxMenuItemActionPerformed

    private void orderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderComboBoxActionPerformed
        App.blockSequence = (DiskRun.BlockSequence) orderComboBox.getSelectedItem();
    }//GEN-LAST:event_orderComboBoxActionPerformed

    private void writeSyncCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeSyncCheckBoxMenuItemActionPerformed
        App.writeSyncEnable = writeSyncCheckBoxMenuItem.getState();
        App.saveConfig();
    }//GEN-LAST:event_writeSyncCheckBoxMenuItemActionPerformed

    private void clearRunsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearRunsItemActionPerformed
        App.msg("Clearing previous runs.");
        App.clearSavedRuns();
    }//GEN-LAST:event_clearRunsItemActionPerformed
    // End of variables declaration//GEN-END:variables

    public void setLocation(String path) {
        locationText.setText(path);
    }

    public void msg(String message) {
        msgTextArea.append(message + '\n');
    }

    public void applyTestParams() {
        String modeStr = (String) modeCombo.getSelectedItem();
        App.readTest = modeStr.contains("read");
        App.writeTest = modeStr.contains("write");
        App.blockSequence = (DiskRun.BlockSequence) orderComboBox.getSelectedItem();
        App.numOfMarks = Integer.valueOf((String) numFilesCombo.getSelectedItem());
        App.numOfBlocks = Integer.valueOf((String) numBlocksCombo.getSelectedItem());
        App.blockSizeKb = Integer.valueOf((String) blockSizeCombo.getSelectedItem());
        fileSizeLabel.setText(String.valueOf(App.targetMarkSizeKb()));
        totalTxProgBar.setString(String.valueOf(App.targetTxSizeKb()));
    }

    public void refreshWriteMetrics() {
        String value;
        value = App.wMin == -1 ? "- -" : df.format(App.wMin);
        wMinLabel.setText(value);
        value = App.wMax == -1 ? "- -" : df.format(App.wMax);
        wMaxLabel.setText(value);
        value = App.wAvg == -1 ? "- -" : df.format(App.wAvg);
        wAvgLabel.setText(value);
    }

    public void refreshReadMetrics() {
        String value;
        value = App.rMin == -1 ? "- -" : df.format(App.rMin);
        rMinLabel.setText(value);
        value = App.rMax == -1 ? "- -" : df.format(App.rMax);
        rMaxLabel.setText(value);
        value = App.rAvg == -1 ? "- -" : df.format(App.rAvg);
        rAvgLabel.setText(value);
    }

    public javax.swing.JProgressBar getProgressBar() {
        return totalTxProgBar;
    }

    public void clearMessages() {
        msgTextArea.setText("");
    }

    public void adjustSensitivity() {
        if (App.state == App.State.DISK_TEST_STATE) {
            startButton.setText("Cancel");
            orderComboBox.setEnabled(false);
            blockSizeCombo.setEnabled(false);
            numBlocksCombo.setEnabled(false);
            numFilesCombo.setEnabled(false);
            modeCombo.setEnabled(false);
            resetButton.setEnabled(false);
        } else if (App.state == App.State.IDLE_STATE) {
            startButton.setText("Start");
            orderComboBox.setEnabled(true);
            blockSizeCombo.setEnabled(true);
            numBlocksCombo.setEnabled(true);
            numFilesCombo.setEnabled(true);
            modeCombo.setEnabled(true);
            resetButton.setEnabled(true);
        }
    }

}
