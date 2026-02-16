# Turistguide 2

---

# Projektgennemgang: Turistguide Web Frontend

Dette dokument giver en oversigt over det aktuelle projekt, "matador", i forhold til kravene specificeret i "Turistguide 2" (Web Frontend). Projektet er en Spring Boot-applikation designet til at levere en webbrugerflade for administration af turistattraktioner.

## Overordnet status

Projektet opfylder langt de fleste kernekrav for en web frontend baseret på HTML og Thymeleaf. Funktionalitet til visning, oprettelse, opdatering og sletning af turistattraktioner er implementeret, ligesom understøttelse af tags og lokationer. Der er en mindre uoverensstemmelse i projektnavnet og en delvis implementering af testkravene.

## Detailleret gennemgang af krav

### 1. Introduktion & Læringsmål (HTML, Thymeleaf, CSS)
*   **Status:** **OPFYLDT**
*   **Detaljer:** Projektet anvender Spring Boot med Thymeleaf til dynamiske HTML-sider og har CSS-styling (`main.css`) korrekt integreret. Controller-metoder returnerer visningsnavne, og data overføres via `Model`-objekter, hvilket erstatter `ResponseEntity` for HTML-visninger som specificeret.

### 2. Spring Boot Projektopsætning
*   **Status:** **OPFYLDT (med mindre afvigelse i navn)**
*   **Detaljer:** Projektet er en Spring Boot-applikation med Maven, og `pom.xml` inkluderer `spring-boot-starter-thymeleaf` og `spring-boot-starter-webmvc`. Pakkestrukturen er konsistent. Projektnavnet er dog "matador" i stedet for "TouristGuide". Forældreversionen af Spring Boot i `pom.xml` er opdateret til `3.2.3` for at sikre en stabil og moderne base.

### 3. Visning af alle turistattraktioner (attractionList.html)
*   **Status:** **OPFYLDT**
*   **Detaljer:** Endpoint `/attractions` (GET) viser `attractionList.html` med alle turistattraktioner i en tabel. Attraktionens navn, beskrivelse, lokation og tags vises. CSS (`main.css`) er korrekt inkluderet. En "Tilføj attraktion"-knap er nu tilføjet i bunden af siden.

### 4. Visning af tags for turistattraktioner (tags.html)
*   **Status:** **OPFYLDT**
*   **Detaljer:** `attractionList.html` indeholder en "Tags"-knap for hver attraktion, der navigerer til endpointet `/{name}/tags`. Dette endpoint viser `tags.html`, som korrekt præsenterer tags for den valgte attraktion samt en "Tilbage"-knap.

### 5. Oprettelse af turistattraktion (attraction-creation-form.html)
*   **Status:** **OPFYLDT**
*   **Detaljer:** Projektet understøtter oprettelse af nye turistattraktioner via et GET-endpoint (`/attractions/add`), som viser `attraction-creation-form.html`. Formularen tillader indtastning af navn, beskrivelse, lokation (dynamisk dropdown) og tags (dynamiske checkboxes). Data gemmes via et POST-endpoint (`/attractions/add`). `TouristAttraction`-modellen inkluderer `location` og en liste af `Tags`.

### 6. Ændring af turistattraktion (updateAttraction.html)
*   **Status:** **OPFYLDT**
*   **Detaljer:** `attractionList.html` inkluderer en "Opdater"-knap, der fører til endpointet `/attractions/edit/{name}`. Her vises `updateAttraction.html`, hvor navn er skrivebeskyttet, men beskrivelse, lokation og tags kan ændres. Ændringer gemmes via et POST-endpoint (`/attractions/edit/{name}`).

### 7. Sletning af turistattraktion
*   **Status:** **OPFYLDT**
*   **Detaljer:** En "Slet"-knap er tilgængelig på `attractionList.html`, som navigerer til en bekræftelsesside (`confirmDelete.html`). Efter bekræftelse slettes attraktionen via et POST-endpoint (`/attractions/delete/{name}`).

### 8. Web Layer Slice test af Controlleren
*   **Status:** **DELVIST OPFYLDT (verifikation påkrævet/udvidelse anbefales)**
*   **Detaljer:** Filen `TouristControllerTest.java` eksisterer og anvender `@WebMvcTest` og `@MockitoBean`, hvilket indikerer korrekt opsætning for web layer slice testing med MockMVC og Mockito. Nogle kernefunktionaliteter (getAllAttractions, showTouristAttractionCreationForm, getTagsForTouristAttraction, addTouristAttraction) er testet. Dog mangler der tests for sletning og opdatering, samt at de eksisterende placeholder-tests (`register()`, `ShouldDeleteByName()`, `getUpdateAttraction()`, `updateAttraction()`) implementeres fuldt ud.

### 9. Ekstraopgaver
*   **Status:** **IKKE IMPLEMENTERET (som forventet)**
*   **Detaljer:** De specificerede ekstraopgaver (HTML/CSS-forbedringer, billetpris) er ikke implementeret, men disse var heller ikke kernekrav.

---

