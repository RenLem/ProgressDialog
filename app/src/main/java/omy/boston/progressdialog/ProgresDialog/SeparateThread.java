package omy.boston.progressdialog.ProgresDialog;

import android.app.ProgressDialog;

/**
 * Created by LosFrancisco on 15-Jan-17.
 */

public class SeparateThread extends Thread {

    private ProgressDialog progDialog;
    private boolean imaProgresa;

    public SeparateThread(ProgressDialog progDialog, boolean imaProgresa){
        this.progDialog = progDialog;
        this.imaProgresa = imaProgresa;
    }

    @Override
    public void run() {
        if (imaProgresa){
            sleepWithProgress();
        }else {
            sleepWithNoProgress();
        }
        progDialog.dismiss();
    }

    public void sleepWithProgress(){
        try {
            while (progDialog.getProgress()<100){
                Thread.sleep(98);
                progDialog.incrementProgressBy(1);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleepWithNoProgress(){
        try {
            Thread.sleep(2870);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
