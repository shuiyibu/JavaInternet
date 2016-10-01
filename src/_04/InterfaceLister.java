package _04;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfaceLister {
	// name:lo (Software Loopback Interface 1)
	// name:net0 (Microsoft ISATAP Adapter)
	// name:eth0 (Microsoft Kernel Debug Network Adapter)
	// name:eth1 (Intel(R) Ethernet Connection I217-LM)
	// name:net1 (Teredo Tunneling Pseudo-Interface)
	// name:eth2 (Intel(R) Ethernet Connection I217-LM-WFP Native MAC Layer
	// LightWeight Filter-0000)
	// name:eth3 (Intel(R) Ethernet Connection I217-LM-QoS Packet
	// Scheduler-0000)
	// name:eth4 (Intel(R) Ethernet Connection I217-LM-WFP 802.3 MAC Layer
	// LightWeight Filter-0000)
	// name:net2 (WAN Miniport (SSTP))
	// name:net3 (WAN Miniport (IKEv2))
	// name:net4 (WAN Miniport (L2TP))
	// name:net5 (WAN Miniport (PPTP))
	// name:ppp0 (WAN Miniport (PPPOE))
	// name:eth5 (WAN Miniport (IP))
	// name:eth6 (WAN Miniport (IP)-WFP Native MAC Layer LightWeight
	// Filter-0000)
	// name:eth7 (WAN Miniport (IP)-QoS Packet Scheduler-0000)
	// name:eth8 (WAN Miniport (IPv6))
	// name:eth9 (WAN Miniport (IPv6)-WFP Native MAC Layer LightWeight
	// Filter-0000)
	// name:eth10 (WAN Miniport (IPv6)-QoS Packet Scheduler-0000)
	// name:eth11 (WAN Miniport (Network Monitor))
	// name:eth12 (WAN Miniport (Network Monitor)-WFP Native MAC Layer
	// LightWeight Filter-0000)
	// name:eth13 (WAN Miniport (Network Monitor)-QoS Packet Scheduler-0000)

	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();
				System.out.println(networkInterface);
			}
			
			System.out.println("-----------");
			NetworkInterface eth0=NetworkInterface.getByName("eth6");
			Enumeration<InetAddress> addresses=eth0.getInetAddresses();
			while (addresses.hasMoreElements()) {
				System.out.println(addresses.nextElement()); 
				
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
