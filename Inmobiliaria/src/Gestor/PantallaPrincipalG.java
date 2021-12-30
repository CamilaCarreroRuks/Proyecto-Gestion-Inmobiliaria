package Gestor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.PantallaPrincipal;
import static Vista.PantallaPrincipal.escritorio;

/**
 *
 * @author Camila Carrero
 */
public class PantallaPrincipalG implements ActionListener {

    PantallaPrincipal pp = new PantallaPrincipal();

    public PantallaPrincipalG() {
        iniciar(pp);
    }

    public void iniciar(PantallaPrincipal pp) { //Inicia las variables y agrega los listener.
        this.pp = pp;
        this.pp.smClientes.addActionListener(this);
        this.pp.smAgregarCliente.addActionListener(this);
        this.pp.smTipoCliente.addActionListener(this);
        this.pp.smAgregarTipoCliente.addActionListener(this);
        this.pp.smPropiedades.addActionListener(this);
        this.pp.smAgregarPropiedad.addActionListener(this);
        this.pp.smTipoPropiedad.addActionListener(this);
        this.pp.smAgregarTipoPropiedad.addActionListener(this);
        this.pp.smOperaciones.addActionListener(this);
        this.pp.smZonas.addActionListener(this);

        this.pp.smGenerarTasacion.addActionListener(this);
        this.pp.smTasaciones.addActionListener(this);

        this.pp.smContrato.addActionListener(this);
        this.pp.smAgregarContrato.addActionListener(this);
        this.pp.smContabilidad.addActionListener(this);
        this.pp.smComprobantes.addActionListener(this);

        this.pp.smAgenda.addActionListener(this);
        this.pp.smComunicacion.addActionListener(this);
        this.pp.smInconveniente.addActionListener(this);
        this.pp.smSeguimiento.addActionListener(this);
        this.pp.smReportes.addActionListener(this);
        this.pp.smCerrarSesion.addActionListener(this);
        this.pp.smUsuarios.addActionListener(this);
        this.pp.smAgregarUsuario.addActionListener(this);
        this.pp.smTipoUsuario.addActionListener(this);
        this.pp.smAgregarTipoUsuario.addActionListener(this);
    }

    public void abrirPantalla() { //Abre PantallaPrincipal.
        pp.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pp.smClientes) {
            ClienteG cg = new ClienteG();
            cg.abrirPanel();
        }

        if (e.getSource() == pp.smAgregarCliente) {
            ClienteG cg = new ClienteG();
            cg.anularBoton("modificar");
            escritorio.removeAll();
            escritorio.revalidate();
            escritorio.repaint();
            cg.abrirFormCliente(true);
        }

        if (e.getSource() == pp.smTipoCliente) {
            TipoClienteG tcg = new TipoClienteG();
            tcg.abrirPanel();
        }

        if (e.getSource() == pp.smAgregarTipoCliente) {
            TipoClienteG tcg = new TipoClienteG();
            tcg.anularBoton("modificar");
            escritorio.removeAll();
            escritorio.revalidate();
            escritorio.repaint();
            tcg.abrirFormTipoCliente();
        }

        if (e.getSource() == pp.smPropiedades) {
            PropiedadG pg = new PropiedadG();
           // pg.abrirPanel();
        }

        if (e.getSource() == pp.smAgregarPropiedad) {
            PropiedadG pg = new PropiedadG();
            // pg.abrirFormPropiedad();
        }

        if (e.getSource() == pp.smTipoPropiedad) {

        }

        if (e.getSource() == pp.smAgregarTipoPropiedad) {

        }

        if (e.getSource() == pp.smOperaciones) {

        }

        if (e.getSource() == pp.smZonas) {

        }

        if (e.getSource() == pp.smGenerarTasacion) {
            TasacionG t = new TasacionG();
            escritorio.removeAll();
            escritorio.revalidate();
            escritorio.repaint();
            t.generarTasacion(true);
        }

        if (e.getSource() == pp.smTasaciones) {
            TasacionG t = new TasacionG();
            t.abrirPanel();
        }

        if (e.getSource() == pp.smContabilidad) {
            ContabilidadG cg = new ContabilidadG();
            cg.abrirPanel();
        }

        if (e.getSource() == pp.smComprobantes) {
            ComprobanteG comg = new ComprobanteG();
            comg.abrirPanel();
        }

        if (e.getSource() == pp.smAgenda) {
            AgendaG a = new AgendaG();
            a.abrirPanel();
        }

        if (e.getSource() == pp.smComunicacion) {
            ComunicacionG comug = new ComunicacionG();
            comug.abrirPanel();
        }

        if (e.getSource() == pp.smInconveniente) {
            InconvenientesG i = new InconvenientesG();
            escritorio.removeAll();
            escritorio.revalidate();
            escritorio.repaint();
            i.abrirFormInconveniente();
        }

        if (e.getSource() == pp.smSeguimiento) {
            InconvenientesG i = new InconvenientesG();
            i.abrirPanelInconveniente();
        }

        if (e.getSource() == pp.smReportes) {
            ReportesG rg = new ReportesG();
            escritorio.removeAll();
            escritorio.revalidate();
            escritorio.repaint();
            rg.abrirFormReportes();
        }

        if (e.getSource() == pp.smCerrarSesion) {
            pp.setVisible(false);
            UsuarioG ug = new UsuarioG();
            ug.login();
        }

        if (e.getSource() == pp.smUsuarios) {
            UsuarioG ug = new UsuarioG();
            ug.abrirPanel();
        }

        if (e.getSource() == pp.smAgregarUsuario) {
            UsuarioG ug = new UsuarioG();
            ug.anularBoton("modificar");
            escritorio.removeAll();
            escritorio.revalidate();
            escritorio.repaint();
            ug.abrirFormUsuario(true);
        }

        if (e.getSource() == pp.smTipoUsuario) {
            TipoUsuarioG tug = new TipoUsuarioG();
            tug.abrirPanel();
        }

        if (e.getSource() == pp.smAgregarTipoUsuario) {
            TipoUsuarioG tug = new TipoUsuarioG();
            tug.anularBoton("modificar");
            escritorio.removeAll();
            escritorio.revalidate();
            escritorio.repaint();
            tug.abrirFormUsuario();
        }
    }
}
