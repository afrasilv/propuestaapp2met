package es.unex.afrasilv.tfg.prop2met;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by alex on 17/06/15.
 */
public class DialogActivity extends AppCompatActivity {

    boolean sesionIniciada;
    String[] arrayValuesCards = new String[] {"Card Developer", "Card Pintor"};
    int selectCard;
    final ArrayList<String> listValuesCards = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sesionIniciada = getIntent().getBooleanExtra("sesionIniciada", false);

        if(sesionIniciada == true)
            sesionIniciada = true;
        else {
            setContentView(R.layout.dialog_activity);
            optionsWithoutLogin();
        }
    }

    /**
     * Control all buttons to the dialog without login
     */
    public void optionsWithoutLogin(){
        Button buttonInicSes = (Button) findViewById(R.id.initSession);
        Button register = (Button) findViewById(R.id.register);
        Button settings = (Button) findViewById(R.id.settings);

        buttonInicSes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_login);
                login();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_register);
                register();
            }
        });


        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_noacc_settings);
                settingsNoAccount();
            }
        });

    }

    /**
     * Control login layout to the dialog
     */
    public void login(){
        Button backInit = (Button) findViewById(R.id.backToInit);
        Button login = (Button) findViewById(R.id.login);

        backInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_activity);
                optionsWithoutLogin();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.menu_account);
                menuWtLogin();
            }
        });
    }

    /**
     * Control register layout to the dialog
     */
    public void register(){
        Button backInit = (Button) findViewById(R.id.backToInit);
        Button register = (Button) findViewById(R.id.register);

        backInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_activity);
                optionsWithoutLogin();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(DialogActivity.this, "Te has registrado con éxito", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.dialog_activity);
                optionsWithoutLogin();
            }
        });
    }

    public void menuWtLogin(){
        Button myCards = (Button) findViewById(R.id.myCards);
        Button newCard = (Button) findViewById(R.id.newCard);
        Button settings = (Button) findViewById(R.id.settings);

        if(listValuesCards.isEmpty()) {
            for (int i = 0; i < arrayValuesCards.length; i++) {
                listValuesCards.add(arrayValuesCards[i]);
            }
        }

        myCards.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.card_list);
                ListView lv = (ListView) findViewById(R.id.listTeacherSubjects);
                final StableArrayAdapter adapter = new StableArrayAdapter(getApplicationContext(), listValuesCards, 1);
                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, final View view,
                                            int position, long id) {
                        final String item = (String) parent.getItemAtPosition(position);
                        Toast.makeText(DialogActivity.this, "Has seleccionado la tarjeta "+item, Toast.LENGTH_SHORT).show();
                        selectCard = position;
                        setContentView(R.layout.dialog_card);
                        TextView tv = (TextView) findViewById(R.id.nameCard);
                        tv.setText(item);
                        cardMenu();
                    }

                });

                accountCards();
            }
        });

        newCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(DialogActivity.this, "Nueva tarjeta... Próximamente", Toast.LENGTH_SHORT).show();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_account_settings);
                settingsAccount();
            }
        });
    }

    public void accountCards(){
        Button backToAccount = (Button) findViewById(R.id.backToAccount);

        backToAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.menu_account);
                menuWtLogin();
            }
        });
    }

    public void cardMenu(){
        Button backToCards = (Button) findViewById(R.id.backToCards);
        Button editImageCard = (Button) findViewById(R.id.editImage);
        Button editARResources = (Button) findViewById(R.id.editARResources);
        Button settings = (Button) findViewById(R.id.settingsCard);

        backToCards.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.card_list);
                ListView lv = (ListView) findViewById(R.id.listTeacherSubjects);
                final StableArrayAdapter adapter = new StableArrayAdapter(getApplicationContext(), listValuesCards, 1);
                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, final View view,
                                            int position, long id) {
                        final String item = (String) parent.getItemAtPosition(position);
                        Toast.makeText(DialogActivity.this, "Has seleccionado la tarjeta "+item, Toast.LENGTH_SHORT).show();
                        selectCard = position;
                        setContentView(R.layout.dialog_card);
                        TextView tv = (TextView) findViewById(R.id.nameCard);
                        tv.setText(item);
                        cardMenu();
                    }

                });

                accountCards();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_card_settings);
                cardSettings();
            }
        });
    }

    public void settingsAccount(){
        Button backToAccount = (Button) findViewById(R.id.backToAccount);
        Button editDataAccount = (Button) findViewById(R.id.editDataAccount);
        Button about = (Button) findViewById(R.id.about);
        Button closeSession = (Button) findViewById(R.id.closeSession);

        backToAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.menu_account);
                menuWtLogin();
            }
        });

        editDataAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.edit_account_data);
                editData();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(DialogActivity.this, R.style.AlertDialog_AppCompat);
                builder.setTitle(R.string.app_name);
                builder.setMessage(R.string.content);
                builder.setPositiveButton("Aceptar", null);
                builder.show();
            }
        });

        closeSession.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_activity);
                sesionIniciada = false;
                optionsWithoutLogin();
            }
        });
    }

    public void editData(){
        Button backToSettings = (Button) findViewById(R.id.backToSettings);
        Button editData = (Button) findViewById(R.id.editAccountData);
        Button removeAccount = (Button) findViewById(R.id.deleteAccount);

        backToSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_account_settings);
                settingsAccount();
            }
        });

        editData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(DialogActivity.this, "Se han modificado los datos de su cuenta", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.dialog_account_settings);
                settingsAccount();
            }
        });

        removeAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                final AlertDialog.Builder dialogDeleteAccount = new AlertDialog.Builder(DialogActivity.this);
                dialogDeleteAccount.setTitle("Eliminar cuenta");
                dialogDeleteAccount.setMessage(R.string.deleteAccount);
                dialogDeleteAccount.setPositiveButton("Cancelar", null);
                dialogDeleteAccount.setNegativeButton("Eliminar Cuenta", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        Toast.makeText(DialogActivity.this, "Has eliminado su cuenta. Esperamos volver a contar con usted.", Toast.LENGTH_SHORT).show();

                        setContentView(R.layout.dialog_activity);
                        optionsWithoutLogin();
                    }
                });
                dialogDeleteAccount.show();
            }
        });
    }

    public void settingsNoAccount(){
        Button backToAccount = (Button) findViewById(R.id.backToInit);
        Button about = (Button) findViewById(R.id.about);

        backToAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_activity);
                optionsWithoutLogin();
            }
        });


        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(DialogActivity.this, R.style.AlertDialog_AppCompat);
                builder.setTitle(R.string.app_name);
                builder.setMessage(R.string.content);
                builder.setPositiveButton("Aceptar", null);
                builder.show();
            }
        });

    }

    public void cardSettings(){
        Button backToCard = (Button) findViewById(R.id.backToCard);
        Button editName = (Button) findViewById(R.id.editNameCard);
        Button deleteCard = (Button) findViewById(R.id.deleteCard);

        backToCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setContentView(R.layout.dialog_card);
                TextView tv = (TextView) findViewById(R.id.nameCard);
                tv.setText(arrayValuesCards[selectCard]);
                cardMenu();
            }
        });


        editName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(DialogActivity.this, "Editar nombre...", Toast.LENGTH_SHORT).show();
            }
        });

        deleteCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                final AlertDialog.Builder deletecard = new AlertDialog.Builder(DialogActivity.this);
                deletecard.setTitle(R.string.app_name);
                deletecard.setMessage(R.string.deleteCard);
                deletecard.setPositiveButton("Cancelar", null);
                deletecard.setNegativeButton("Eliminar Tarjeta", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        setContentView(R.layout.card_list);
                        ListView lv = (ListView) findViewById(R.id.listTeacherSubjects);
                        final StableArrayAdapter adapter = new StableArrayAdapter(getApplicationContext(), listValuesCards, 1);
                        lv.setAdapter(adapter);

                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> parent, final View view,
                                                    int position, long id) {
                                final String item = (String) parent.getItemAtPosition(position);
                                Toast.makeText(DialogActivity.this, "Has seleccionado la tarjeta " + item, Toast.LENGTH_SHORT).show();
                                selectCard = position;
                                setContentView(R.layout.dialog_card);
                                TextView tv = (TextView) findViewById(R.id.nameCard);
                                tv.setText(item);
                                cardMenu();
                            }

                        });

                        accountCards();
                    }
                });
                deletecard.show();
            }
        });
    }


    private class StableArrayAdapter extends ArrayAdapter<String> {

        private final Context context;
        private final List<String> listValues;
        private int optionSelect;


        public StableArrayAdapter(Context context, List<String> objects, int option) {
            super(context, -1, objects);
            this.context = context;
            this.listValues = objects;
            this.optionSelect = option;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(optionSelect == 0) {
                View rowView = inflater.inflate(R.layout.item_hide_anim, parent, false);
                TextView tv = (TextView) rowView.findViewById(R.id.rowText);
                tv.setText(listValues.get(position));
                return rowView;
            }
            else{
                View rowView = inflater.inflate(R.layout.card_subject, parent, false);
                TextView tv = (TextView) rowView.findViewById(R.id.subjectName);
                tv.setText(listValues.get(position));
                return rowView;
            }
        }

    }
}
