<%-- 
    Document   : map
    Created on : Feb 29, 2024, 2:35:26 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>/* 
 * Always set the map height explicitly to define the size of the div element
 * that contains the map. 
 */
            #map {
                height: 100%;
            }
          
            html,
            body {
                height: 100%;
                margin: 0;
                padding: 0;
            }</style>
        <script async
                src="https://maps.googleapis.com/maps/api/js?key=&loading=async&callback=initMap">
        </script>
    </head>
    <body>
        <div id="map"></div>

        <!-- prettier-ignore -->
        <script>(g => {
                var h, a, k, p = "The Google Maps JavaScript API", c = "google", l = "importLibrary", q = "__ib__", m = document, b = window;
                b = b[c] || (b[c] = {});
                var d = b.maps || (b.maps = {}), r = new Set, e = new URLSearchParams, u = () => h || (h = new Promise(async(f, n) => {
                        await (a = m.createElement("script"));
                        e.set("libraries", [...r] + "");
                        for (k in g)
                            e.set(k.replace(/[A-Z]/g, t => "_" + t[0].toLowerCase()), g[k]);
                        e.set("callback", c + ".maps." + q);
                        a.src = `https://maps.${c}apis.com/maps/api/js?` + e;
                        d[q] = f;
                        a.onerror = () => h = n(Error(p + " could not load."));
                        a.nonce = m.querySelector("script[nonce]")?.nonce || "";
                        m.head.append(a)
                    }));
                d[l] ? console.warn(p + " only loads once. Ignoring:", g) : d[l] = (f, ...n) => r.add(f) && u().then(() => d[l](f, ...n))
            })
                    ({key: "AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg", v: "weekly"});</script>
    </body>
</html>
<script>
    let map;

    async function initMap() {
        const {Map} = await google.maps.importLibrary("maps");

        map = new Map(document.getElementById("map"), {
            center: {lat: 21.0278, lng:  105.8342},
            zoom: 8,
        });
    }

    initMap();
</script>
