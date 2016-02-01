import java.io.UnsupportedEncodingException; 
import java.util.*;
 public class naryTree {  
      public static void main(String[] args) throws UnsupportedEncodingException {  
           Node root = new Node("5");  
           Node ch1 = new Node("8");  
           Node ch2 = new Node("9");  
           Node ch3 = new Node("11");  
           root.addChild(ch1);  
           root.addChild(ch2);  
           root.addChild(ch3);  
           Node ch4 = new Node("13");  
           Node ch5 = new Node("17");  
           Node ch6 = new Node("18");  
           Node ch7 = new Node("20");  
           Node ch8 = new Node("22");  
           ch1.addChild(ch4);  
           ch1.addChild(ch5);  
           ch4.addChild(ch6);  
           ch6.addChild(ch7);  
           ch7.addChild(ch8);  
           Node ch9 = new Node("23");  
           Node ch10 = new Node("25");  
           Node ch11 = new Node("27");  
           Node ch12 = new Node("28");  
           Node ch13 = new Node("32");  
           Node ch14 = new Node("31");  
           Node ch15 = new Node("33");  
           Node ch16 = new Node("34");  
           Node ch17 = new Node("29");  
           ch5.addChild(ch9);  
           ch3.addChild(ch10);  
           ch3.addChild(ch11);  
           ch10.addChild(ch12);  
           ch10.addChild(ch14);  
           ch12.addChild(ch13);  
           ch14.addChild(ch15);  
           ch14.addChild(ch16);  
           ch14.addChild(ch17);  
           String packed = Node.serialization(root);  
           System.out.println(packed);  
           Node compareTo = Node.deserialization(packed);  
           System.out.println(root.equals(compareTo));  
      }  
 }  

 class Node {
		String key;
		ArrayList<Node> childs = null;
		public Node(String key) {
			this.key = key;
			childs = new ArrayList<Node>();
		}
		public void addChild(Node child) {
			this.childs.add(child);
			return;
		}
		public static String serialization(Node root) {
			StringBuffer sb = new StringBuffer();
			if(root != null) {
				sb.append(".");
				sb.append(root.key);
			    sb.append(".");
			    for(Node child : root.childs) {
			    	sb.append(Node.serialization(child));
			    }
			    sb.append(")");
			}
			return sb.toString();
		}
		public static Node deserialization(String node) {
			Node res = null;
			Stack<Node> stack = new Stack<Node>();
			boolean isData = false;
			StringBuffer data = null;
			for(int i = 0; i < node.length(); i++) {
				if(node.charAt(i) == '.') {
					isData = !isData;
					if(isData) {
						data = new StringBuffer();
					}
					else {
						Node child = new Node(data.toString());
						if(!stack.isEmpty()) {
							Node parent = stack.peek();
							parent.addChild(child);
						}
						else {
							res = child;
						}
						stack.push(child);
					}
				}
				else {
					if(isData) {
						data.append(node.charAt(i));
					}
					else if(node.charAt(i) == ')') {
						stack.pop();
					}
				}
			}
			return res;
		}
	}