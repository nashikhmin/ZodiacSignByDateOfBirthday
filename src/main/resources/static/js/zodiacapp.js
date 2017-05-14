// jQuery to collapse the navbar on scroll
function collapseNavbar() {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
}

$(window).scroll(collapseNavbar);
$(document).ready(collapseNavbar);

// handler menu click
$(function () {
    $('a.page-scroll').bind('click', function (event) {
        var $anchor = $(this);
        scrollTo($anchor.attr('href'));
    });
});

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function () {
    $(".navbar-collapse").collapse('hide');
});


//Post date handler
$(document).ready(function () {
    var url = window.location;
    // SUBMIT FORM
    $("#dateForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {
        // PREPARE FORM DATA
        var formData = {
            day: 3,
            month: 3
        }

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: url + "/zodiacSign",
            data: JSON.stringify(formData),
            success: function (result) {
                if (result.status == "DONE") {
                    var sign = result.zodiacSign.toLowerCase();
                    scrollTo('#' + sign);
                } else {
                    alert("Wrong result!");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }
})

//scroll to href element
function scrollTo(href) {
    $('html, body').stop().animate({
        scrollTop: $(href).offset().top
    }, 1500, 'easeInOutExpo');
    event.preventDefault();
}

