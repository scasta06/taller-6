package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener
{

    private PanelMapaVisualizar panelMapa;

    private JRadioButton radioTodos;

    private JRadioButton radioVisitados;

    private VentanaPrincipal ventanaPrincipal;

    public VentanaMapa( VentanaPrincipal ventanaPrincipal, List<Restaurante> restaurantes )
    {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle( "Mapa de restaurantes" );
        panelMapa = new PanelMapaVisualizar( );
        panelMapa.actualizarMapa( restaurantes );
        add( panelMapa, BorderLayout.CENTER );

        radioTodos = new JRadioButton( "Todos", true );
        radioVisitados = new JRadioButton( "Visitados" );
        ButtonGroup grupo = new ButtonGroup( );
        grupo.add( radioTodos );
        grupo.add( radioVisitados );
        radioTodos.addActionListener( this );
        radioVisitados.addActionListener( this );
        JPanel filtros = new JPanel( );
        filtros.add( radioTodos );
        filtros.add( radioVisitados );
        add( filtros, BorderLayout.SOUTH );

        pack( );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLocationRelativeTo( null );
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        actualizarMapa( );
    }

    public void actualizarMapa( )
    {
        panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( radioTodos.isSelected( ) ) );
    }
}
