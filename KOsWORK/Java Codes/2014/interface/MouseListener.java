public interface MouseListener {
    public void mouseClicked(MouseEvent e)
    {
    	if(e.getModifiers()==MouseEvent.BUTTON1_MASK)
    	{
    		//FIRE THE MAIN WEAPONS! KO:????
    	}
    }
    
    public void mousePressed(MouseEvent e)
    {
    	System.out.println("The mouse is at "+ e.getX() + " " + e.getY());
    }    
}