package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PanelMapaAgregar extends JPanel implements MouseListener
{

    private JLabel labMapa;

    private int x;

    private int y;

    public PanelMapaAgregar( )
    {
        this.labMapa = new JLabel( new ImageIcon( "./imagenes/mapa.png" ) );
        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        labMapa.addMouseListener( this );
        add( labMapa );

        this.x = -1;
        this.y = -1;
    }

    public int[] getCoordenadas( )
    {
        return new int[]{ x, y };
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint( g );

        Graphics2D g2d = ( Graphics2D )g;
        g2d.setColor( Color.red );
        if( x >= 0 )
            g2d.fillOval( labMapa.getX( ) + 1 + x - 3, labMapa.getY( ) + 1 + y - 3, 7, 7 );
    }

    @Override
    public void mouseClicked( MouseEvent e )
    {
        if( e.getX( ) < 1 || e.getY( ) < 1 || e.getX( ) >= labMapa.getWidth( ) - 1 || e.getY( ) >= labMapa.getHeight( ) - 1 )
            return;
        this.x = e.getX( ) - 1;
        this.y = e.getY( ) - 1;
        repaint( );
    }

    @Override
    public void mousePressed( MouseEvent e )
    {
    }

    @Override
    public void mouseReleased( MouseEvent e )
    {
    }

    @Override
    public void mouseEntered( MouseEvent e )
    {
    }

    @Override
    public void mouseExited( MouseEvent e )
    {
    }

}
