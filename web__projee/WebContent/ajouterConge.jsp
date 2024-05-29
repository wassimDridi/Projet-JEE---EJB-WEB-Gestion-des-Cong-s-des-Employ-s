<!DOCTYPE html>
<html>
<head>
    <title>Demander un nouveau congé</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        h2 {
            text-align: center;
        }
        .form-container {
            max-width: 500px;
            width: 100%;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: calc(100% - 20px);
            padding: 8px;
            margin-left: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            display: block;
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container" >
        <h2>Demander un nouveau congé</h2>
        <form action="ajouterConge" method="post">
            <div class="form-group">
                <label for="description">Description :</label>
                <input type="text" id="description" name="description" required>
            </div>
            <div class="form-group">
                <label for="dateDebut">Date de début :</label>
                <input type="date" id="dateDebut" name="dateDebut" required>
            </div>
            <div class="form-group">
                <label for="dateFin">Date de fin :</label>
                <input type="date" id="dateFin" name="dateFin" required>
            </div>
            <div class="form-group">
                <label for="dateRupture">Date de rupture :</label>
                <input type="date" id="dateRupture" name="dateRupture" required>
            </div>
            <button type="submit" >Demander</button>
        </form>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const form = document.querySelector('form');
            const dateDebutInput = document.getElementById('dateDebut');
            const dateFinInput = document.getElementById('dateFin');
            const dateRuptureInput = document.getElementById('dateRupture');
            
            form.addEventListener('submit', function(event) {
                const dateDebut = new Date(dateDebutInput.value);
                const dateFin = new Date(dateFinInput.value);
                const dateRupture = new Date(dateRuptureInput.value);
                
                if (dateFin <= dateDebut) {
                    alert('La date de fin doit être postérieure à la date de début.');
                    event.preventDefault();
                }
                
                if (dateRupture <= dateDebut) {
                    alert('La date de rupture doit être postérieure à la date de début.');
                    event.preventDefault();
                }
                });
                });
                </script>

                </body>
                </html>
