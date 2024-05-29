<!DOCTYPE html>
<html>
<head>
    <title>Employee Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
        }
        .dashboard-container {
            background: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 100%;
            max-width: 600px;
        }
        h2 {
            color: #333;
        }
        p {
            font-size: 18px;
            color: #666;
        }
        .link-container {
            margin-top: 20px;
            display: flex;
            justify-content: space-around;
        }
        a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #0056b3;
        }
        .alert {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 4px;
            text-align: left;
            width: 100%;
            max-width: 600px;
        }
        .alert-success {
            background-color: #d4edda;
            color: #155724;
        }
        .alert-error {
            background-color: #f8d7da;
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h2>Employee Dashboard</h2>
        <p>Bienvenue, Employé!</p>
        
        <%
            String message = (String) session.getAttribute("message");
            String messageType = (String) session.getAttribute("messageType");
            if (message != null && messageType != null) {
        %>
            <div class="alert <%= messageType.equals("success") ? "alert-success" : "alert-error" %>">
                <%= message %>
            </div>
            <%
                session.removeAttribute("message");
                session.removeAttribute("messageType");
            %>
        <% } %>
        
        <div class="link-container">
            <a href="ajouterConge.jsp">Ajouter un nouveau congé</a>
            <a href="consultationConges.jsp">Consulter les congés</a>
        </div>
    </div>
</body>
</html>
