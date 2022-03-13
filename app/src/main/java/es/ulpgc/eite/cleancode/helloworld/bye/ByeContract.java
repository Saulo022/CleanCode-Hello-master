package es.ulpgc.eite.cleancode.helloworld.bye;

import java.lang.ref.WeakReference;

public interface ByeContract {

    interface View {
        void injectPresenter(Presenter presenter);

        //Creacion de metodo displayByeData siguiendo modelo del HelloActivity
        void displayByeData(ByeViewModel viewModel);


        //void navigateToNextScreen();

        void finishView();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResumeCalled();

        void sayByeButtonClicked();

        void goHelloButtonClicked();
    }

    interface Model {
        String getByeMessage();

    }

}