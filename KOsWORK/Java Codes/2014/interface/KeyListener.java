public interface KeyListener {
	public void keyPressed(KeyEvent e)
	{
		int keyCode= e.getKeyCode();
		if(keycode == KeyEvent.VK_W)
		System.out.println("You pressed up!");
	}
	
	public void keyReleased()
	{}
	
	public void keyTyped(KeyEvent e)
	{
		char key = e.getKeyChar();
		switch(char)
		{
			case 'r':
			{
				System.out.println("You typed an R");
				break;
			}
		}
	}
	
}