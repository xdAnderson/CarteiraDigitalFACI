package com.example.lpa.carteiradigitalfaci_pt.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Usuário "+Usuario.USUARIO_ATIVO.getUSER_nome()+" logado.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentMenuPrincipal()).commit();

        if(Usuario.BV==1){
            //Abrirá um fragment de boas vindas
            Usuario.BV=0;
        }


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            setTitle("Carteira Digital");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentMenuPrincipal()).commit();

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

        if (id == R.id.nav_main) {
            setTitle("Carteira Digital");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentMenuPrincipal()).commit();
        } else if (id == R.id.nav_certidao) {
            setTitle("Certidão");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentCertidao()).commit();
        } else if (id == R.id.nav_rg) {
            setTitle("Registro Geral (RG)");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentRG()).commit();
        } else if (id == R.id.nav_cpf) {
            setTitle("Comp. Pessoa Física (CPF)");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentCPF()).commit();
        } else if (id == R.id.nav_cnh) {
            setTitle("Cart. Nac. de Habilitação");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentCNH()).commit();
        } else if (id == R.id.nav_ctps) {
            setTitle("Cart. Trab. e Previdência Social");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentCTPS()).commit();
        } else if (id == R.id.nav_titulo) {
            setTitle("Título de Eleitor");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentTitulo()).commit();
        } else if (id == R.id.nav_reservista) {
            setTitle("Reservista");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentReservista()).commit();
        } else if (id == R.id.nav_outros) {
            setTitle("Outros Documentos");
            fragmentManager.beginTransaction().replace(R.id.content_fragment, new FragmentOutros()).commit();
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
