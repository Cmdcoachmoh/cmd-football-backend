import sgMail from "@sendgrid/mail";
import dotenv from "dotenv";

dotenv.config();

export interface EmailData {
  to: string;
  subject: string;
  template: "milestone"; // add more templates later
  data: Record<string, any>;
}

sgMail.setApiKey(process.env.SENDGRID_API_KEY!);

// ✅ Template renderer
function renderTemplate(template: string, data: Record<string, any>) {
  switch (template) {
    case "milestone":
      return `
        <div style="font-family: Arial, sans-serif; padding: 20px;">
          <img src="${data.logoUrl}" alt="CMD Football" width="120" />
          <h2 style="color:#0A3D62;">🎉 Progress Update</h2>
          <p><strong>${data.playerName}</strong> has reached <strong>${data.milestone}</strong>.</p>
          <p>Keep pushing, keep growing — excellence is built one touch at a time.</p>
        </div>
      `;
    default:
      return "<p>No template found.</p>";
  }
}

// ✅ Email sender
const sendEmail = async ({ to, subject, template, data }: EmailData) => {
  const html = renderTemplate(template, data);

  await sgMail.send({
    to,
    from: "cmd-football@yourdomain.com",
    subject,
    html
  });
};

export default sendEmail;
