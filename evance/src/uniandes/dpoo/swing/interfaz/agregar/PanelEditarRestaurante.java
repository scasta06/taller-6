package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{

    private JTextField txtNombre;

    private JComboBox<String> cbbCalificacion;

    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {

        txtNombre = new JTextField( 12 );

        cbbCalificacion = new JComboBox<>( new String[]{ "1", "2", "3", "4", "5" } );

        cbbVisitado = new JComboBox<>( new String[]{ "No", "Sí" } );

        setLayout( new GridLayout( 3, 1 ) );
        agregarFila( "Nombre:", txtNombre );
        agregarFila( "Calificación:", cbbCalificacion );
        agregarFila( "Visitado:", cbbVisitado );

    }

    private void agregarFila( String nombre, javax.swing.JComponent componente )
    {
        JPanel fila = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        fila.add( new JLabel( nombre ) );
        fila.add( componente );
        add( fila );
    }

    public boolean getVisitado( )
    {

        return cbbVisitado.getSelectedIndex( ) == 1;
    }

    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    public String getNombre( )
    {

        return txtNombre.getText( ).trim( );
    }
}
