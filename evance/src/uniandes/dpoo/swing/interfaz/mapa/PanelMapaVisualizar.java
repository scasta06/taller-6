package uniandes.dpoo.swing.interfaz.mapa;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{

    private JLabel labMapa;

    private List<Restaurante> restaurantes = new ArrayList<>( );

    public PanelMapaVisualizar( )
    {
        this.labMapa = new JLabel( new ImageIcon( "./imagenes/mapa.png" ) );
        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        add( labMapa );
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2d = ( Graphics2D )g;

        g2d.setColor( Color.RED );
        for( Restaurante r : restaurantes )
        {
            int x = labMapa.getX( ) + 1 + r.getX( );
            int y = labMapa.getY( ) + 1 + r.getY( );
            g2d.fillOval( x - 3, y - 3, 7, 7 );
            int ancho = g2d.getFontMetrics( ).stringWidth( r.getNombre( ) );
            int textoX = Math.min( x + 5, labMapa.getX( ) + labMapa.getWidth( ) - ancho - 1 );
            int textoY = Math.max( y, labMapa.getY( ) + g2d.getFontMetrics( ).getAscent( ) + 1 );
            g2d.drawString( r.getNombre( ), Math.max( labMapa.getX( ) + 1, textoX ), textoY );
        }
    }

    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        restaurantes = new ArrayList<>( nuevosRestaurantes );
        repaint( );
    }
}
