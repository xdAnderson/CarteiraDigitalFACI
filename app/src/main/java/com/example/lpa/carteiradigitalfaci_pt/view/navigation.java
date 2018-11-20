package com.example.lpa.carteiradigitalfaci_pt.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lpa.carteiradigitalfaci_pt.R;
import com.example.lpa.carteiradigitalfaci_pt.controller.DocumentoController;
import com.example.lpa.carteiradigitalfaci_pt.controller.UsuarioController;
import com.example.lpa.carteiradigitalfaci_pt.model.Usuario;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentCNH;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentCPF;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentCTPS;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentCertidao;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentMenuPrincipal;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentOutros;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentRG;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentReservista;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.FragmentTitulo;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentCNHCad;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentCPFCad;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentCTPSCad;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentCertidaoCad;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentOutrosCad;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentRGCad;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentReservistaCad;
import com.example.lpa.carteiradigitalfaci_pt.view.fragment.fragmentCad.FragmentTituloCad;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FloatingActionButton fab = findViewById(R.id.fab_add);


        fab.setAlpha(0.5f);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Usuário "+Usuario.USUARIO_ATIVO.getUSER_nome()+" logado.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        replaceFragmentWithAnimation(new FragmentMenuPrincipal(), "fgMP", "Carteira Digital");

        if(Usuario.BV==1){
            //Abrirá um fragment de boas vindas
            Usuario.BV=0;
        }


    }
    public static void replaceFragmentWithAnimation(Fragment fragment, String tag){
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.res_anim_fadein, R.anim.res_anim_fadeout).replace(R.id.content_fragment, fragment).commit();


    }
    public void replaceFragmentWithAnimation(Fragment fragment, String tag, String titulo){
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.res_anim_fadein, R.anim.res_anim_fadeout).replace(R.id.content_fragment, fragment, tag).commit();
        setTitle(titulo);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        Fragment nomeFragment = fragmentManager.findFragmentByTag("fgMP");

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (nomeFragment != null && nomeFragment.isVisible()) {
                new AlertDialog.Builder(navigation.this)
                        .setTitle("Fechar aplicação...")
                        .setMessage("Deseja fechar a aplicação?")
                        .setPositiveButton("Sim",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finishAffinity();
                                    }
                                })
                        .setNegativeButton("Não",null)
                        .show();

            }else{
                replaceFragmentWithAnimation(new FragmentMenuPrincipal(), "fgMP", "Carteira Digital");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_sair) {
            UsuarioController uc = new UsuarioController(getApplicationContext());
            uc.zerarUltimoUsuario();
            Toast.makeText(getApplicationContext(), "Efetuando Logoff", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(navigation.this, Login.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DocumentoController documentoController = new DocumentoController(getApplicationContext());
        if (id == R.id.nav_main) {
            replaceFragmentWithAnimation(new FragmentMenuPrincipal(), "fgMP", "Carteira Digital");
        } else
            if (id == R.id.nav_certidao) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"certidao")){
                    replaceFragmentWithAnimation(new FragmentCertidao(), "fgCert","Certidão de Nascimento");
                }else
                    replaceFragmentWithAnimation(new FragmentCertidaoCad(), "fgCertCad","Certidão de Nascimento");
        } else
            if (id == R.id.nav_rg) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"rg")){
                    replaceFragmentWithAnimation(new FragmentRG(), "fgRG","\"Registro Geral (RG)\"");
                }else
                    replaceFragmentWithAnimation(new FragmentRGCad(), "fgRGCad","\"Registro Geral (RG)\"");
        } else
            if (id == R.id.nav_cpf) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"cpf")){
                    replaceFragmentWithAnimation(new FragmentCPF(), "fgCPF","Cad. Pessoa Física (CPF)");
                }else
                    replaceFragmentWithAnimation(new FragmentCPFCad(), "fgCPFCad","Cad. Pessoa Física (CPF)");

        } else
            if (id == R.id.nav_cnh) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"cnh")){
                    replaceFragmentWithAnimation(new FragmentCNH(), "fgCNH","Cart. Nac. de Habilitação");
                }else
                    replaceFragmentWithAnimation(new FragmentCNHCad(), "fgCNHCad","Cart. Nac. de Habilitação");

        } else
            if (id == R.id.nav_ctps) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"ctps")){
                    replaceFragmentWithAnimation(new FragmentCTPS(), "fgCTPS","Cart. Trab. e Previdência Social");
                }else
                    replaceFragmentWithAnimation(new FragmentCTPSCad(), "fgCTPSCad","Cart. Trab. e Previdência Social");

        } else
            if (id == R.id.nav_titulo) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"titulo")){
                    replaceFragmentWithAnimation(new FragmentTitulo(), "fgTit","Título de Eleitor");
                }else
                    replaceFragmentWithAnimation(new FragmentTituloCad(), "fgTitCad","Título de Eleitor");

        } else if (id == R.id.nav_reservista) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"reservista")){
                    replaceFragmentWithAnimation(new FragmentReservista(), "fgRes","Reservista");
                }else
                    replaceFragmentWithAnimation(new FragmentReservistaCad(), "fgResCad","Reservista");

        } else
            if (id == R.id.nav_outros) {
                if(documentoController.verificarSePossuiDocumento(Integer.toString(Usuario.USUARIO_ATIVO.getUSER_id()),"outros")){
                    replaceFragmentWithAnimation(new FragmentOutros(), "fgOut","Outros Documentos");
                }else
                    replaceFragmentWithAnimation(new FragmentOutrosCad(), "fgOutCad","Outros Documentos");

        } else if (id == R.id.nav_config) {
            startActivity(new Intent(navigation.this, ConfigActivity.class));
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_fb) {

        } else if (id == R.id.nav_sair) {
            UsuarioController uc = new UsuarioController(getApplicationContext());
            uc.zerarUltimoUsuario();
            Toast.makeText(getApplicationContext(), "Efetuando Logoff", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(navigation.this, Login.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
