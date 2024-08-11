<%@page import = "com.mycompany.ecommerce5.entities.user" %>

<%
user user1=(user)session.getAttribute("current-user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NILE - Home</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Titan+One&display=swap" rel="stylesheet"> <!-- Changed font link to Titan One -->
    <link rel="icon" href="D:\Programming\Java\android-chrome-512x512.png" type="image/png"> <!-- Added favicon -->

    <style>
        /* Basic styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 20px 0; /* Added padding to create gap between navbar and top */
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding-top: 40px;
        }

        /* Navbar styling */
        .navbar {
            background-color: #b3e5fc; /* Changed navbar color */
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-radius: 50px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1); /* Updated box-shadow */
            position: fixed;
            width: 90%;
            top: -80px; /* Start from top, outside of the viewport */
            left: 50%;
            transform: translateX(-50%);
            z-index: 999;
            transition: top 1.0s; /* Increased transition duration */
            margin-top: 20px; /* Added margin-top for gap above navbar */
        }

        .show-navbar {
            top: 0; /* Slide the navbar into view */
        }

        .logo {
            font-family: 'Titan One', cursive; /* Changed font to Titan One */
            font-size: 30px;
            color: #1565c0; /* Changed logo color */
            cursor: pointer;
            text-decoration: none;
            transition: text-shadow 0.3s ease;
            margin-left: 10px; /* Adjusted margin-left for spacing */
        }

        .logo:hover {
            text-shadow: 0 0 10px rgba(255, 255, 255, 0.7), /* Increased blur radius and spread for brightness and smoothness */
                         0 0 20px rgba(255, 255, 255, 0.5), /* Added an additional layer for smoother glow */
                         0 0 30px rgba(255, 255, 255, 0.3); /* Added another layer for smoother glow */
        }

        .button-container {
            display: flex;
            align-items: center;
        }

        .button {
            padding: 8px 20px; /* Adjusted padding for equal size */
            background-color: transparent; /* Initial background color set to transparent */
            color: #1565c0;
            border: 1px solid transparent; /* Initial border set to transparent */
            border-radius: 20px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
            transition: background-color 0.3s ease, border-color 0.3s ease; /* Added transition for background and border color */
        }

        .button:hover {
            border-color: #000; /* Change border color to black on hover */
            color: #000;
        }

        .transparent {
            background-color: transparent;
            color: #51BBFE;
            border: 1px solid #51BBFE;
        }

        .transparent:hover {
            background-color: #4299e1;
            color: #ffffff;
        }

        .vertical-line {
            border-left: 1px solid #000; /* Changed border color to black */
            height: 15px;
            margin: 0 10px; /* Adjusted margin for equal gaps */
        }

        /* Sub-navbar styling */
        .sub-navbar {
            background-color: #e0f7fa;
            padding: 8px 0;
            border-radius: 30px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: none;
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
            z-index: 998;
            opacity: 1;
            width: 80%;
            white-space: nowrap;
            transition: top 1s ease;
transition: down 1s ease; /* Transition for top property */
            top: 80px; /* Start from top, outside of the viewport */
        }

        .sub-navbar.show {
            display: block;
            opacity: 1;
transition: top 2s ease;
 
            top: 90.8px; /* Adjusted top position */
        }

        .sub-navbar-item {
            display: inline-block; /* Display horizontally */
            padding: 8px 20px; /* Adjusted padding */
            text-decoration: none;
            color: #333;
            transition: color 0.3s ease;
            margin: 0 5px; /* Added margin for spacing */
        }

        .sub-navbar-item:hover {
            color: #000;
        }

        /* Search bar styling */
        .search-bar {
            position: relative; /* Ensure position relative for absolute positioning of icon */
            display: flex;
            align-items: center;
            margin-right: 15px;
            margin-left: 30px;
        }

        .search-input {
            padding: 10px;
            border-radius: 25px;
            border: 2px solid transparent; /* Changed border to transparent */
            width: 200px;
            font-size: 14px;
            color: #333;
            outline: none; /* Remove outline */
        }

        .search-input:focus {
            border-color: #1565c0; /* Change border color on focus */
        }

        .search-icon-container {
            position: absolute;
            right: 10px;
            width: 30px;
            height: 30px;
            border-radius: 50%;
            background-color: #1565c0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .search-icon {
            color: white;
            font-size: 18px;
        }

        .search-input::placeholder {
            color: #999; /* Placeholder text color */
        }

        .search-input:focus {
            outline: none; /* Remove outline on focus */
            border-color: #1565c0; /* Change border color on focus */
            box-shadow: 0 0 3px rgba(21, 101, 192, 0.5), 0 1px 2px rgba(0, 0, 0, 0.1); /* Adjusted box shadow on focus */
        }

        .button-container {
            margin-left: auto; /* Pushes the button container to the right */
            margin-right: 20px; /* Added margin to create space between buttons and right edge */
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="index.jsp" class="logo">NILE</a>
        <div class="search-bar">
            <input type="text" class="search-input" placeholder="What are you looking for?..">
            <div class="search-icon-container">
                <i class="material-icons search-icon">search</i>
            </div>
        </div>
        <div class="button-container">
            <button class="button categories-btn">Shop by Categories <span>&#9660;</span></button>
            <div class="vertical-line"></div>
            
            
            <li class="nav-item active">
          <a class="nav-link" href="#" data-toggle="modal" data-target="#cart"><i class="fa fa-cart-plus" style="font-size: 20px;"></i><span class="ml-0 cart-items" >( 0 )</span> </a>
       </li>
    
            
            
            
        
            <%
                if(user1 == null){
                
                
                %>
                
                
            <a href="login.jsp" class="button">Login</a>
            <div class="vertical-line"></div>
            <a href="register.jsp" class="button">Register</a>
            
            <%
            }else{


            %>
             <a href="" class="button"><%= user1.getUserName() %> </a>
            <div class="vertical-line"></div>
            <a href="LogoutServlet" class="button">Logout</a>
      
            
            <%
                }
                %>
        </div>
    </div>
    <div class="sub-navbar">
        <!-- Sub-navbar items -->
        <!-- Example categories, replace with your own -->
        <a href="#" class="sub-navbar-item">Shoes</a>
        <a href="#" class="sub-navbar-item">Clothes</a>
        <a href="#" class="sub-navbar-item">Denim</a>
        <a href="#" class="sub-navbar-item">Category 4</a>
    </div>
    <div class="sub-header"> 
        <!-- You can add any additional elements you want in the sub-header here -->
    </div>
    <div class="main-content">
        <!-- Item 1 -->
        <!-- Add your content here -->
    </div>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const navbar = document.querySelector('.navbar');
            navbar.classList.add('show-navbar');
            const categoriesBtn = document.querySelector('.categories-btn');
            const subNavbar = document.querySelector('.sub-navbar');

            // Function to show sub-navbar with a delay
            function showSubNavbar() {
                setTimeout(function() {
                    subNavbar.classList.add('show');
                }, 100); // 2 seconds delay
            }

            // Function to hide sub-navbar with a delay
            function hideSubNavbar() {
                setTimeout(function() {
                    subNavbar.classList.remove('show');
                }, 700); 
            }

            // Toggle sub-navbar on click
            categoriesBtn.addEventListener('click', function() {
                if (!subNavbar.classList.contains('show')) {
			subNavbar.style.top = '40px'; // Slide down
			setTimeout(showSubNavbar, 20); // Show after slide down animation
			subNavbar.style.top = '90px'; // Slide down
                    setTimeout(showSubNavbar, 20); // Show after slide down animation
                } else {
                    subNavbar.style.top = '-20px'; // Slide up
                    hideSubNavbar();
                }
                categoriesBtn.classList.toggle('locked');
            });

            // Close sub-navbar when clicking outside
            document.addEventListener('click', function(event) {
                if (!subNavbar.contains(event.target) && !categoriesBtn.contains(event.target)) {
                    subNavbar.style.top = '-20px'; // Slide up
                    hideSubNavbar();
                    categoriesBtn.classList.remove('locked');
                }
            });

        });
    </script>
</body>
</html>
