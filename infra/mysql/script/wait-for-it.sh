#!/bin/bash

# Récupére l'hôte et le port à partir des arguments
host="$1"
port="$2"

# Décaler les arguments pour obtenir la commande à exécuter
shift 2
cmd="$@"

# Vérifier si 'nc' (netcat) est installé
if ! command -v nc &> /dev/null; then
    echo "Erreur : 'nc' (netcat) n'est pas installé."
    exit 1
fi

# Attendre que l'hôte et le port soient disponibles
while ! nc -z "$host" "$port"; do
    echo "⏳ En attente de $host:$port..."
    sleep 2
done

echo "✅ $host:$port est prêt, démarrage de l'application..."

# Exécuter la commande passée en argument
exec $cmd