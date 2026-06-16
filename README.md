<h1 align="center">🧠 AI Resume Analyzer</h1>

<p align="center">
An AI-powered Resume Analyzer built using <b>Spring Boot</b> that evaluates resumes against job descriptions and provides actionable insights.
</p>

<hr/>

<h2>🚀 Features</h2>
<ul>
  <li>📄 Upload Resume (PDF/Text)</li>
  <li>🧠 AI-based Resume Analysis</li>
  <li>✅ Skill Matching with Job Description</li>
  <li>❌ Missing Skills Identification</li>
  <li>📊 Resume Scoring System</li>
  <li>💡 Personalized Suggestions</li>
</ul>

<hr/>

<h2>🛠️ Tech Stack</h2>
<ul>
  <li><b>Backend:</b> Java, Spring Boot</li>
  <li><b>AI:</b> OpenAI API </li>
  <li><b>Build Tool:</b> Maven</li>
  <li><b>Version Control:</b> Git & GitHub</li>
</ul>

<hr/>

<h2>📂 Project Structure</h2>

<pre>
Resume_Analyzer/
 ├── src/main/java/
 ├── src/main/resources/
 ├── pom.xml
 ├── target/
 └── README.md
</pre>

<hr/>

<h2>⚙️ Setup & Installation</h2>

<h3>1. Clone Repository</h3>
<pre>git clone https://github.com/your-username/AI_Resume_Analyzer.git</pre>

<h3>2. Add API Key</h3>
<pre>OPENAI_API_KEY=your_api_key_here</pre>

<h3>3. Build Project</h3>
<pre>mvn clean install</pre>

<h3>4. Run Application</h3>
<pre>mvn spring-boot:run</pre>

<hr/>

<h2>🔌 API Endpoint</h2>

<table border="1" cellpadding="8" cellspacing="0">
<tr>
  <th>Method</th>
  <th>Endpoint</th>
  <th>Description</th>
</tr>
<tr>
  <td>POST</td>
  <td>/analyze</td>
  <td>Analyze resume with job description</td>
</tr>
</table>

<hr/>

<h2>📊 Sample Output</h2>

<pre>
{
  "score": 75,
  "matchedSkills": ["Java", "Spring Boot"],
  "missingSkills": ["Docker", "Kubernetes"],
  "suggestions": [
    "Add backend projects",
    "Include cloud technologies"
  ]
}
</pre>

<hr/>

<h2>🧠 How It Works</h2>
<ol>
  <li>Resume is parsed into text</li>
  <li>Job description is analyzed</li>
  <li>AI compares both</li>
  <li>Outputs score, skills, and suggestions</li>
</ol>

<hr/>

<h2>📌 Future Improvements</h2>
<ul>
  <li>🌐 Frontend UI (React)</li>
  <li>📈 Advanced scoring</li>
  <li>🔍 ATS compatibility check</li>
  <li>📊 Dashboard analytics</li>
</ul>

<hr/>

<h2>👨‍💻 Author</h2>
<p>
Devansh <br/>
B.Tech ECE | IIIT Una <br/>
Backend & AI Enthusiast
</p>
