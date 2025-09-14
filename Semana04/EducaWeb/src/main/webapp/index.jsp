<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String mensaje = null;
	if(request.getAttribute("mensaje") != null){
		mensaje = request.getAttribute("mensaje").toString();
	}
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Formulario de Acceso</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        
        .login-container {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 100%;
            max-width: 400px;
            border: 1px solid rgba(255, 255, 255, 0.2);
        }
        
        .login-header {
            text-align: center;
            margin-bottom: 30px;
        }
        
        .login-header h2 {
            color: #333;
            font-weight: 700;
            margin-bottom: 10px;
        }
        
        .login-header p {
            color: #666;
            font-size: 14px;
        }
        
        .form-floating label {
            color: #666;
        }
        
        .form-control {
            border: 2px solid #e1e5e9;
            border-radius: 12px;
            padding: 12px 15px;
            transition: all 0.3s ease;
            background: rgba(255, 255, 255, 0.9);
        }
        
        .form-control:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 0.2rem rgba(102, 126, 234, 0.25);
            background: rgba(255, 255, 255, 1);
        }
        
        .btn-login {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border: none;
            border-radius: 12px;
            padding: 12px 30px;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 1px;
            transition: all 0.3s ease;
            position: relative;
            overflow: hidden;
        }
        
        .btn-login:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 25px rgba(102, 126, 234, 0.3);
        }
        
        .btn-login:active {
            transform: translateY(0);
        }
        
        .remember-forgot {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin: 20px 0;
            font-size: 14px;
        }
        
        .forgot-password {
            color: #667eea;
            text-decoration: none;
            transition: color 0.3s ease;
        }
        
        .forgot-password:hover {
            color: #764ba2;
            text-decoration: underline;
        }
        
        .form-check-input:checked {
            background-color: #667eea;
            border-color: #667eea;
        }
        
        .input-group-text {
            background: rgba(255, 255, 255, 0.9);
            border: 2px solid #e1e5e9;
            border-right: none;
            color: #666;
        }
        
        .input-group .form-control {
            border-left: none;
        }
        
        .input-group:focus-within .input-group-text {
            border-color: #667eea;
        }
        
        .alert {
            border-radius: 12px;
            border: none;
            margin-bottom: 20px;
        }
        
        .social-login {
            margin-top: 30px;
            padding-top: 20px;
            border-top: 1px solid #e1e5e9;
        }
        
        .btn-social {
            border-radius: 12px;
            border: 2px solid #e1e5e9;
            background: white;
            color: #666;
            transition: all 0.3s ease;
            margin-bottom: 10px;
        }
        
        .btn-social:hover {
            transform: translateY(-1px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-header">
            <h2><i class="bi bi-shield-lock"></i> Iniciar Sesión</h2>
            <p>Ingresa tus credenciales para acceder</p>
        </div>
        
        <!-- Alerta de error (oculta por defecto) d-none-->
		<% if(mensaje != null){%>
        <div class="alert alert-danger " id="errorAlert" role="alert">
            <i class="bi bi-exclamation-triangle"></i>
            <span id="errorMessage"><%= mensaje %></span>
        </div>
        <% } %>
		
       
        <form id="loginForm" novalidate method="post" action="Login">
            <!-- Campo Usuario -->
            <div class="mb-3">
                <div class="input-group">
                    <span class="input-group-text">
                        <i class="bi bi-person"></i>
                    </span>
                    <div class="form-floating flex-grow-1">
                        <input 
                            type="text" 
                            class="form-control" 
                            id="usuario" 
                            name="usuario"
                            placeholder="Nombre de usuario"
                            required
                            autocomplete="username"
                        >
                        <label for="usuario">Usuario</label>
                    </div>
                    <div class="invalid-feedback">
                        Por favor ingresa tu nombre de usuario.
                    </div>
                </div>
            </div>
            
            <!-- Campo Contraseña -->
            <div class="mb-3">
                <div class="input-group">
                    <span class="input-group-text">
                        <i class="bi bi-lock"></i>
                    </span>
                    <div class="form-floating flex-grow-1 position-relative">
                        <input 
                            type="password" 
                            class="form-control" 
                            id="clave" 
                            name="clave"
                            placeholder="Contraseña"
                            required
                            autocomplete="current-password"
                        >
                        <label for="clave">Contraseña</label>
                        <button 
                            type="button" 
                            class="btn btn-link position-absolute end-0 top-50 translate-middle-y me-2 p-0 border-0 bg-transparent"
                            id="togglePassword"
                            style="z-index: 10; color: #666;"
                        >
                            <i class="bi bi-eye" id="eyeIcon"></i>
                        </button>
                    </div>
                    <div class="invalid-feedback">
                        Por favor ingresa tu contraseña.
                    </div>
                </div>
            </div>
            
            
            <!-- Botón de envío -->
            <div class="d-grid mb-3">
                <button class="btn btn-primary btn-login" type="submit">
                    <span class="spinner-border spinner-border-sm d-none me-2" id="loginSpinner" role="status" aria-hidden="true"></span>
                    <span id="loginButtonText">Iniciar Sesión</span>
                </button>
            </div>
        </form>
        

    <!-- Bootstrap 5 JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    
    <script>
        // Toggle password visibility
        const togglePassword = document.getElementById('togglePassword');
        const passwordInput = document.getElementById('clave');
        const eyeIcon = document.getElementById('eyeIcon');
        
        togglePassword.addEventListener('click', function() {
            const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
            passwordInput.setAttribute('type', type);
            
            if (type === 'password') {
                eyeIcon.classList.remove('bi-eye-slash');
                eyeIcon.classList.add('bi-eye');
            } else {
                eyeIcon.classList.remove('bi-eye');
                eyeIcon.classList.add('bi-eye-slash');
            }
        });
        
        // Form validation and submission
        const loginForm = document.getElementById('loginForm');
        const errorAlert = document.getElementById('errorAlert');
        const successAlert = document.getElementById('successAlert');
        const loginSpinner = document.getElementById('loginSpinner');
        const loginButtonText = document.getElementById('loginButtonText');
        
		
        
        // Clear validation on input
        const inputs = loginForm.querySelectorAll('input');
        inputs.forEach(input => {
            input.addEventListener('input', function() {
                if (this.value.trim() !== '') {
                    this.classList.remove('is-invalid');
                    this.classList.add('is-valid');
                } else {
                    this.classList.remove('is-valid');
                    this.classList.add('is-invalid');
                }
            });
        });
    </script>
</body>
</html>