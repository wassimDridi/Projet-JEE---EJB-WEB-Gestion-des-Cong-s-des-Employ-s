<%@ page import="java.util.List" %>
<%@ page import="domaine.Conge" %>

<!DOCTYPE html>
<html>
<head>
    <title>Consultation des Congés</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 800px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        form label {
            margin-right: 10px;
            align-self: center;
        }
        form select {
            padding: 8px;
            margin-right: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        form button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        form button:hover {
            background-color: #0056b3;
        }
        .conge-list {
            list-style: none;
            padding: 0;
        }
        .conge-item {
            background: #fafafa;
            padding: 15px;
            margin-bottom: 10px;
            border-radius: 4px;
            border: 1px solid #ddd;
        }
        .conge-item p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Historique des Congés</h2>
        <form method="get" action="consulterConges">
            <label for="etat">Filtrer par état :</label>
            <select id="etat" name="etat">
                <option value="">Tous</option>
                <option value="SOLLICITE">SOLLICITE</option>
                <option value="VALIDE">VALIDE</option>
                <option value="REFUSE">REFUSE</option>
                <option value="ANNULE">ANNULE</option>
                <option value="EN_COURS">EN_COURS</option>
                <option value="ARRETE">ARRETE</option>
                <option value="FINI">FINI</option>
            </select>
            <button type="submit">Filtrer</button>
        </form>
        <ul class="conge-list">
        <%
            // Récupérer la liste des congés depuis l'attribut de requête
            List<Conge> conges = (List<Conge>) request.getAttribute("conges");
            if (conges != null && !conges.isEmpty()) {
                for (Conge conge : conges) {
        %>
                    <li class="conge-item">
                        <p><strong>Description :</strong> <%= conge.getDescription() %></p>
                        <p><strong>Date de début :</strong> <%= conge.getDateDebut() %></p>
                        <p><strong>Date de fin :</strong> <%= conge.getDateFin() %></p>
                        <p><strong>État :</strong> <%= conge.getEtat() %></p>
                    </li>
        <%
                }
            } else {
        %>
                <p>Aucun congé trouvé.</p>
        <%
            }
        %>
        </ul>
    </div>
</body>
</html>
