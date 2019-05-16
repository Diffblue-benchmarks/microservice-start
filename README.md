# microservice-start
Level 1: Commnunication and Service Discovery, DONE
========================================================

Movie-catalog-service

Movie-info-service

Rating-data-service

Movie-catalog-service consume the result from other two service and show them on specific URL.

<b>TECHNOLOGY USED:<b>
Spring boot, spring cloud, Spring Eureka




<b>Problem facing<b>
hard coded URL are bad:

	Changes required code updateds
	Dynamic URLs in the cloud
	Load balancing
	Multiple environment: different URL for devleoper, qa, and deployment
	

<b>Solution<b>
Service Discovery:
		
										<-Register
		client --> Discovery server(DS) <------> 	service 1, service 2, service 3
		
		
	-->	
	1) Client Side Service Discovery:
		ask DS
		return Response
		Use reposnse to get service
		
	-->
	2) Service Side Service Discovery:
		client send msg via DS (Incharge to pass msg to service too) [more efficient]
	
	
NOTE: Spring cloud uses client side service discovery	


TECHNOLOGY: Eureka (Service Discovery) provided by Netflix OSS

//libs: Ribbon, Hysterix, Zuul (Netflix OSS)


Steps to making this work:
===========================

	StartUp a Eureka Server
	Have Microservices register(publish) using Eureka Client
	Have Microservices locate(consume) using Eureka Client
	
	
How Fault tolerance works:
=========================
eureka client sends constant heartbeats. (DS will know)
What if DS fails:
	client -> DS f\(fail) ? NO -> cache -> return service.

Level 1: Commnunication and Service Discovery, DONE


Level 2: Fault Tolerance and Resilience (IN PROGRESS)


