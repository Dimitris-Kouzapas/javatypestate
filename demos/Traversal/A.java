package demos.Traversal;
class A implements Runnable {
	int Bport, Cport;
	private Node node;
	A(int Bport, int Cport, Node node){
		this.Bport = Bport;
		this.Cport = Cport;
		this.node = node;
	}
	public void run() {
		Node queue[] = new Node[100];
		queue[0] = node;
		int head = 1;
		int tail = 0;
		boolean bflag = true;
		boolean cflag = true;
		ARole a = new ARole(Bport, Cport);
		loop:
		do {
			if(queue[tail] != null) {
				node = queue[tail++];
				bflag = false;
				cflag = false;
				System.out.println("A: " + node.get());
			}
			else {
				node = null;
			}
			if(node != null && (bflag == false || cflag == false)) {
				if(node.left() != null) {
					a.DATAToB();
					a.nodeToB(node.left());
					bflag = false;
				}
				else {
					a.NO_DToB();
				}
				if(node.right() != null) {
					a.DATAToC();
					a.nodeToC(node.right());
					cflag = false;
				}
				else {
					a.NO_DToC();
				}
				switch(a.choiceFromB().getEnum()){
					case Choice.DATA:
					queue[head++] = a.nodeFromB();
					break;
					case Choice.NO_D:
					break;
					case Choice.END:
					bflag = true;
					break;
				}
				switch(a.choiceFromC().getEnum()){
					case Choice.DATA:
					queue[head++] = a.nodeFromC();
					break;
					case Choice.NO_D:
					break;
					case Choice.END:
					cflag = true;
					break;
				}
				continue loop;
			}
			else {
				a.ENDToB();
				a.ENDToC();
				break loop;
			}
		}
		while(true);
	}
}
