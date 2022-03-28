package codes;

import mvc.controller.ControllerMain;

public class ExecuteAutomaticMail extends Thread{
    
    private final Object monitor=new Object();
    private boolean status=false;
    private final ControllerMain controllerMain;
    
    public ExecuteAutomaticMail(ControllerMain cm){
        super();
        this.controllerMain=cm;
    }
    
    @Override
    public void run(){
        for(int i=0;;i++){
            this.checkForPaused();
            if(controllerMain.jrbManual.isSelected()){
                if(controllerMain.sendMail()){
                    try {
                        Thread.sleep(500);
                        this.stop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.controllerMain.jbtContinue.doClick();
                }else{
                    ExtraCode.sendMessageError("Error: No se pudo enviar el correo, verifique que no se haya enviado anteriormente o \nque haya sido un problema interno.");
                    this.pauseThread();
                }
            }else{
                if(controllerMain.jrbAutomatic.isSelected()){
                    this.controllerMain.sendMailAutomatic();
                }
            }
        }
    }
    
    private void checkForPaused(){
        synchronized(monitor){
            while(status==true){
                try {
                    this.monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void pauseThread(){
        this.status=true;
    }
    
    public void resumeThread() {
        synchronized(monitor) {
            status = false;
            this.monitor.notify();
        }
    }
}
