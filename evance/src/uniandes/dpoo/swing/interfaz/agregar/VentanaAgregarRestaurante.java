package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{

    private PanelEditarRestaurante panelDetalles;

    private PanelBotonesAgregar panelBotones;

    private PanelMapaAgregar panelMapa;

    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        setTitle( "Nuevo restaurante" );
        panelMapa = new PanelMapaAgregar( );
        add( panelMapa, BorderLayout.CENTER );

        JPanel inferior = new JPanel( new BorderLayout( ) );
        panelDetalles = new PanelEditarRestaurante( );
        panelBotones = new PanelBotonesAgregar( this );
        inferior.add( panelDetalles, BorderLayout.CENTER );
        inferior.add( panelBotones, BorderLayout.SOUTH );
        add( inferior, BorderLayout.SOUTH );

        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    public void agregarRestaurante( )
    {
        String nombre = panelDetalles.getNombre( );
        int[] punto = panelMapa.getCoordenadas( );
        if( nombre.isEmpty( ) || punto[0] < 0 )
        {
            javax.swing.JOptionPane.showMessageDialog( this, "Escribe el nombre y marca la ubicación en el mapa." );
            return;
        }
        ventanaPrincipal.agregarRestaurante( nombre, panelDetalles.getCalificacion( ), punto[0], punto[1], panelDetalles.getVisitado( ) );
        cerrarVentana( );
    }

    public void cerrarVentana( )
    {
        dispose( );
    }

}
