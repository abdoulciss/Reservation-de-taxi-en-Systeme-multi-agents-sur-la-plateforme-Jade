# Simulation-reservation-sur-la-plateforme-Jade
Reservation de taxi sur la plateforme JADE

C’est une plate forme technologique qui mettra
en relation passager et chauffeur. Pour ce faire, il est nécessaire de mettre en place
une application destinée à deux groupes, le groupe des passagers et le groupe des
chauffeurs. L’application aura besoin d’être connecté en permanence à la base de
donnée pour effectuer la mise à jour.
Dans ce système il y aura Trois principaux agents qui sont Agents client, agents
taxis et agent de liaison(DF).

Agent client : client (passager) envoi une demande de transport caractérisée par
les coordonnées point de départ, point d’arrivée et les fenêtres de temps
associés à ces points. Ainsi que d’autres paramètres telles que le confort du
véhicule et le nombre de places. Ces requêtes seront soumises à l’agent taxi
via l’agent de liaison

Agent de liaison(DF): Après la réception des exigences auprès de l’agent client,
il vérifie la disponibilité, le nombre de place, le type et la distance a parcourir
puis envoie les réponses a agent de taxi.A la réception des informations (val-
idation par l’agent taxi) auprès de l’agent taxi, il assure la négociation et la
planification. Il fera un retour à l’agent client de l’offre avec les rubriques
selon les exigences du client.

Agent de taxi: Il reçoit les informations auprès de l’agent liaison. Il réponds à
chaque requête soit par un avis favorable à l’agent de liaison (DF).

#Veuillez consulter le fichier pdf pour plus d'infromation
