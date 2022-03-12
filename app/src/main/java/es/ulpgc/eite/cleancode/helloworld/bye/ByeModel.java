package es.ulpgc.eite.cleancode.helloworld.bye;

public class ByeModel implements ByeContract.Model {

    public static String TAG = ByeModel.class.getSimpleName();

    //Cambiamos data por message2 y creamos metodo getByeMessage como en HelloModel
    private String message2;

    public ByeModel(String message2) { this.message2 = message2; }

    @Override
    public String getByeMessage() { return message2;}



    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return message2;
    }


    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}