package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{

    private JLabel labNombre;

    private JLabel labCalificacion;

    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante( )
    {

        labNombre = new JLabel( );

        labCalificacion = new JLabel( );

        chkVisitado = new JCheckBox( );
        chkVisitado.setEnabled( false );

        setLayout( new GridLayout( 3, 1 ) );
        agregarFila( "Nombre:", labNombre );
        agregarFila( "Calificación:", labCalificacion );
        agregarFila( "Visitado:", chkVisitado );
    }

    private void agregarFila( String nombre, javax.swing.JComponent componente )
    {
        JPanel fila = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        fila.add( new JLabel( nombre ) );
        fila.add( componente );
        add( fila );
    }

    private void actualizarRestaurante( String nombre, int calificacion, boolean visitado )
    {
        labNombre.setText( nombre );
        labCalificacion.setIcon( calificacion == 0 ? null : buscarIconoCalificacion( calificacion ) );
        chkVisitado.setSelected( visitado );
    }

    public void actualizarRestaurante( Restaurante r )
    {
        if( r == null )
            actualizarRestaurante( "", 0, false );
        else
            this.actualizarRestaurante( r.getNombre( ), r.getCalificacion( ), r.isVisitado( ) );
    }

    private ImageIcon buscarIconoCalificacion( int calificacion )
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon( imagen );
    }
}
